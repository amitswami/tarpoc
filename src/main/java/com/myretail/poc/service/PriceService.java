package com.myretail.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.myretail.poc.entity.Price;

import reactor.core.publisher.Mono;

@Component
public class PriceService {
	
	@Autowired
	private WebClient priceClient ;

	
	public Mono<Price> getPrice(Number productId) {
		return priceClient.get().uri("/rprice/" + productId).retrieve().bodyToMono(Price.class);
	}
	
	

}
