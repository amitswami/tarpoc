package com.myretail.poc.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.myretail.poc.controllers.ProductsController;

@WebFluxTest(controllers=ProductsController.class)
@ExtendWith(SpringExtension.class)
public class PriceServiceTest {
	
	@Autowired
	WebTestClient webTestClient ;
	
	@Test
	@DisplayName("Should get price from price API")
	public void getPrice() {
//		when(webTestClient.get())
		
	}
	

}
