package com.myretail.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.myretail.poc.entity.Product;

import reactor.core.publisher.Mono;

@Component
public class ProductService {
	
	@Autowired
	private WebClient productClient ;
	
	@Value("${PRODUCT_API_HOST}")
	private String productAPIHost;

	
	public Mono<Product> getProduct(Number productId) {
		return productClient.get().uri(productAPIHost + productId).retrieve().bodyToMono(Product.class);
	}
	
	

}
