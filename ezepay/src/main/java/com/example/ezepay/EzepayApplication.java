package com.example.ezepay;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.ezepay.services.AuthenticationService;
import com.example.ezepay.services.CardService;
import com.example.ezepay.services.CustomerService;
import com.example.ezepay.services.TransactionService;


@EnableCircuitBreaker
@SpringBootApplication
public class EzepayApplication {

//	private static final Logger log = LoggerFactory.getLogger(EzepayApplication.class);
	
	public static void main(String[] args) throws IOException {

		SpringApplication.run(EzepayApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRest( ) {
		return new RestTemplate();
	}
	@Bean
	public CustomerService getcs( ) {
		return new CustomerService();
	}
	
	@Bean
	public CardService getcards( ) {
		return new CardService();
	}
	
	@Bean
	public TransactionService getts( ) {
		return new TransactionService();
	}
	
	@Bean
	public AuthenticationService getAuth() {
		return new AuthenticationService();
	}
	
//	  @Bean
//	  public CommandLineRunner demo(MerchantRepository repository) {
//	    return (args) -> {
//
//// 			!!!!____________________DON'T UNCOMMENT : SAVED IN DB EARLIER____________';'__________!!!!
//	    	
////	    	repository.save(new Merchant("Gorgonic", "Active", "www.gorgonic.com", "040-440044"));
////	    	
////	    	repository.save(new Merchant("Nizamazon", "Active", "www.nizamazon.com", "040-550055"));
////	    	
////	    	repository.save(new Merchant("Rapidone", "Active", "www.rapidone.com", "040-660066"));
////	    	
//// 			!!!!____________________DON'T UNCOMMENT : SAVED IN DB EARLIER______________________!!!!
//
//	    	log.info("-------------!!! STATIC Merchants Loaded !!!---------------");
//
//	    };
//	  }
}
