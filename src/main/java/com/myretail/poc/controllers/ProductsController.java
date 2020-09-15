package com.myretail.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private PriceService priceService ;
	
	
	@GetMapping("/{id}")
	public Mono<ProductWithPrice> getProductById(@PathVariable Number id) {
		Mono<Product> product = productService.getProduct(id).subscribeOn(Schedulers.elastic());
		Mono<Price> price = priceService.getPrice(id).subscribeOn(Schedulers.elastic());
		
		return Mono.zip(product, price, ProductWithPrice::new) ;
	}

}
