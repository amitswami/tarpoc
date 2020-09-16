package com.myretail.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.myretail.poc.entity.Price;
import com.myretail.poc.entity.Product;
import com.myretail.poc.entity.ProductWithPrice;
import com.myretail.poc.service.PriceService;
import com.myretail.poc.service.ProductService;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PriceService priceService;

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e) {
		if (e instanceof WebClientResponseException) {
			WebClientResponseException rex = (WebClientResponseException) e;
			return ResponseEntity.status(rex.getRawStatusCode()).body(rex.getMessage());
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<ProductWithPrice>> getProductById(@PathVariable Number id) {
		Mono<Product> product = productService.getProduct(id).subscribeOn(Schedulers.elastic());
		Mono<Price> price = priceService.getPrice(id).subscribeOn(Schedulers.elastic());
		
		Mono<ProductWithPrice> productWithPrice = Mono.zip(product, price, ProductWithPrice::new);
		
		return productWithPrice.map(p -> new ResponseEntity<ProductWithPrice>(p, HttpStatus.OK));


	}

}
