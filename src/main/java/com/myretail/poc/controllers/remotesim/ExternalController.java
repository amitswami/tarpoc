package com.myretail.poc.controllers.remotesim;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.poc.entity.Price;
import com.myretail.poc.entity.Product;

@RestController
@RequestMapping("/remote")
public class ExternalController {
	
	private Product MOCK_PRODUCT = new Product(1, "Mock Product") ;
	private Price MOCK_PRICE = new Price(12.34, "USD") ;
	
	@RequestMapping("/rproduct/{id}")
	public Product getRemoteProduct(@PathVariable String id) {
		return MOCK_PRODUCT; 

	}
	
	@RequestMapping("/rprice/{id}")
	public Price getRemotePrice(@PathVariable String id) {
		return MOCK_PRICE; 

	}

}
