package com.example.ezepay.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ezepay.models.Card;
import com.example.ezepay.models.MerchantRequest;
import com.example.ezepay.repositories.CardRepository;

public class CardService {
	
	
	private static final Logger log = LoggerFactory.getLogger(CardService.class);

	@Autowired
	CardRepository cardRepository;
	
	public Card findAndUpdateCard(MerchantRequest merchantRequest) {
		
		Card currentCard = cardRepository.findByCard(merchantRequest.getCardBin(), merchantRequest.getCardNum());
		Long currentCardId;
		
		if(currentCard == null) {
			
			currentCard = new Card(merchantRequest.getCardBin(),
									merchantRequest.getCardNum(),
									merchantRequest.getExpiryYear(),
									merchantRequest.getExpiryMonth(),
									merchantRequest.getCardHolderName(), 
									merchantRequest.getIssuer());
			
			currentCard = cardRepository.save(currentCard);
			currentCardId = currentCard.getCardId();
			
			log.info("--------------- NEW CARD entry with Id : " + currentCardId);
		} else {
			currentCardId = currentCard.getCardId();
			log.info("-------------Card found!!  id : " + currentCardId + " Card holder : " + currentCard.getCardHolderName());
		}
		
		return currentCard;
	}
}
