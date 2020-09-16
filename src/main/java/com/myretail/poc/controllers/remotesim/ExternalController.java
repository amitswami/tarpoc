package com.myretail.poc.controllers.remotesim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.poc.entity.Price;
import com.myretail.poc.entity.Product;
import com.myretail.poc.repository.remotesim.PriceRepository;
import com.myretail.poc.repository.remotesim.ProductRepository;

@RestController
@RequestMapping("/remote")
public class ExternalController {
	
//	private Product MOCK_PRODUCT = new Product(1, "Mock Product") ;
//	private Price MOCK_PRICE = new Price(1, 12.34, "USD") ;
	
	@Autowired
	PriceRepository priceRepository ;
	
	@Autowired
	ProductRepository productRepository ;
	
	@RequestMapping("/rproduct/{id}")
	public Product getRemoteProduct(@PathVariable Long id) {
		return productRepository.findById(id).get() ;
//		return MOCK_PRODUCT; 

	}
	
	@RequestMapping("/rprice/{id}")
	public Price getRemotePrice(@PathVariable Long id) {
		return priceRepository.findById(id).get() ;

		//		return MOCK_PRICE; 

	}

}
