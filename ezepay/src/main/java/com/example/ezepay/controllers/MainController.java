package com.example.ezepay.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ezepay.models.Address;
import com.example.ezepay.models.Card;
import com.example.ezepay.models.Customer;
import com.example.ezepay.models.Merchant;
import com.example.ezepay.models.MerchantRequest;
import com.example.ezepay.models.PaymentRequestBody;
import com.example.ezepay.models.PaymentResponseBody;
import com.example.ezepay.models.Transaction;
import com.example.ezepay.repositories.AddressRepository;
import com.example.ezepay.repositories.MerchantRepository;
import com.example.ezepay.repositories.MerchantRequestRepository;
import com.example.ezepay.repositories.PaymentRequestRepository;
import com.example.ezepay.repositories.PaymentResponseRepository;
import com.example.ezepay.repositories.TransactionRepository;
import com.example.ezepay.services.AuthenticationService;
import com.example.ezepay.services.CardService;
import com.example.ezepay.services.CurrencyConversionService;
import com.example.ezepay.services.CustomerService;
import com.example.ezepay.services.TransactionService;


@Controller
public class MainController {
	
	private Long currentMerchantId = (long) 1;
	private Long currentTransactionId;

	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired
	CustomerService customerService;

	@Autowired
	CardService cardService;

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	MerchantRequestRepository requestRepository;
	
	@Autowired
	PaymentRequestRepository paymentRequestRepository;
	
	@Autowired
	PaymentResponseRepository paymentResponseRepository;
	
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CurrencyConversionService currencyConversionService;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/")
	public String getLandingPage(Model model) {
		
		log.info("-------------!!! STATIC Merchants Loaded !!!---------------");
		model.addAttribute("merchants", merchantRepository.findAll());
		
		return "index";
	}
	

	@GetMapping("/merchant/{merchantId}")
	public String getPaymentPage(@PathVariable Long merchantId, Model model) {
		Optional<Merchant> opMerchant = merchantRepository.findById(merchantId); // CrudRepository returns a Optional type : TO avoid error if not found.
		
		Merchant merchant = opMerchant.get();  							// Converting Optional to Merchant
		
		
		log.info("-------------------Using path variable : " + merchantId);
		this.currentMerchantId = merchantId;

		log.info("--------------------retrieved merchant " + merchant.toString());
		model.addAttribute("merchant", merchant);
		
		return "paymentPage";
	}


	@PostMapping("/merchant/payment")
	public String doPayment(Model model,
								@RequestParam(value="email") String email,
								@RequestParam(value="firstName") String firstName,
								@RequestParam(value="lastName") String lastName,
								@RequestParam(value="contact") String contact,
								@RequestParam(value="country") String country,
								@RequestParam(value="zip") String zip,
								@RequestParam(value="state") String state,
								@RequestParam(value="city") String city,
//								@RequestParam(value="iPAddress") String iPAddress,
								@RequestParam(value="dOB") String dOB,
								
								@RequestParam(value="amount", defaultValue = "89") int amount,
								@RequestParam(value="currency", defaultValue= "INR") String currency,
								
								@RequestParam(value="cardBin", defaultValue = "809990") int cardBin,
								@RequestParam(value="cardNum", defaultValue = "8240") int cardNum,
								@RequestParam(value="expiryYear", defaultValue = "2022") int expiryYear,
								@RequestParam(value="expiryMonth", defaultValue = "11") int expiryMonth,
								@RequestParam(value="cardHolderName") String cardHolderName,
								@RequestParam(value="issuer") String issuer) {
		
		
		//----------------------------------------------------------------------------------------------------------------------- every request will be stored in database
		MerchantRequest newRequest = new MerchantRequest(email, firstName, lastName, contact, country, zip, state, city, dOB,
														amount, currency, cardBin, cardNum, expiryYear, expiryMonth, cardHolderName, issuer);
		newRequest = requestRepository.save(newRequest);
		Long merchantRequestId = newRequest.getRequestId();
		log.info("----New Request from the merchant by id : " + merchantRequestId);
		//----------------------------------------------------------------------------------------------------------------------- every request will be stored in database

		
		Customer currentCustomer = customerService.findAndUpdateCustomer(newRequest);
		
		Card currentCard = cardService.findAndUpdateCard(newRequest);

		Long merchantId = this.currentMerchantId;
		
	    
	    
	    String toCurrency = merchantRepository.findById(currentMerchantId).get().getBaseCurrency(); //Post review
	    
	    log.info("--------Merchant base_currency : " + toCurrency + " Customer Currency : " + currency);
	    
	    Double conversionRate = currencyConversionService.getConversionRate(currency, toCurrency); //Post review
	    
	    log.info("-------COnversion rate from " + currency + " to " + toCurrency + " is " + conversionRate);
	    
	    int finalAmount = currencyConversionService.getFinalAmount(amount, conversionRate);							//Post review
	    
	    log.info("----Final Amount for " + amount + " " + currency + " in " + toCurrency + " is " + finalAmount);
	    
		Transaction currentTransaction = new Transaction("Initiated", merchantRequestId,
																	merchantId,
																	merchantRepository.findById(merchantId).get().getName(), // phase 2
																	currentCustomer.getCustomerId(),
																	currentCustomer.getFirstName(),  // phase 2
																	currentCustomer.getContact(),     // phase 2
																	currentCard.getCardId(),
																	amount,
																	currency,
																	toCurrency,
																	conversionRate,
																	finalAmount);
		currentTransaction = transactionRepository.save(currentTransaction);
		
		this.currentTransactionId = currentTransaction.getTransactionId();
		
		addressRepository.save(new Address(currentTransactionId, country, state, city, zip, newRequest.getiPAddress()));

	    PaymentRequestBody requestBody = new PaymentRequestBody(currentTransactionId, cardBin, cardNum, amount, firstName, contact);  
	    PaymentResponseBody responseBody = authenticationService.paymentProcess(requestBody);			// request to simulator for payment process and get response, phase 2
	    
	    requestBody.setReferenceId(responseBody.getReferenceId());         // -- UPDATE referenceId from simulator to the request made
	    paymentRequestRepository.save(requestBody);
	    
	    currentTransaction.setReferenceId(responseBody.getReferenceId());  // -- UPDATE referenceId from simulator to transaction
	    currentTransaction.setStatus(responseBody.getStatus());
	    transactionRepository.save(currentTransaction);
	    
	    if(responseBody.getReferenceId() != null) {
	    	paymentResponseRepository.save(responseBody);	
	    }

	    log.info("--------- Response from Simulator: " + responseBody.getStatus() + '-' + responseBody.getMessage());


	    
	    model.addAttribute("response", responseBody);
		model.addAttribute("merchant", merchantRepository.findById(this.currentMerchantId).get());
	    model.addAttribute("transaction", currentTransaction);
	    
		return "checkout";
	}

	
	@GetMapping("/transactions")
	public String getAllTransactions(Model model) {
		 model.addAttribute("transactions", transactionService.getAllTransactions());
		 return "transactionIndex";
	}
	
	@GetMapping("/customers")
	public String getAllCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());	
		return "customerIndex";
	}
	
}
