package com.myretail.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.myretail.poc.entity.Product;

import reactor.core.publisher.Mono;

@Component
public class ProductService {
	
	@Autowired
	private WebClient productClient ;

	
	public Mono<Product> getProduct(Number productId) {
		return productClient.get().uri("/rproduct/" + productId).retrieve().bodyToMono(Product.class);
	}
	
	

}
