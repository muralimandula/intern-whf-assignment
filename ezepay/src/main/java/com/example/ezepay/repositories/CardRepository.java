package com.example.ezepay.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.Card;


public interface CardRepository extends CrudRepository<Card, Long> {
	
	@Query("select c from Card c where c.cardBin = :cardBin and c.cardNum = :cardNum")
	Card findByCard(int cardBin, int cardNum);
}
