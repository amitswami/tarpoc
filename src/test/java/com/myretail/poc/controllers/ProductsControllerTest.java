package com.myretail.poc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.myretail.poc.entity.Price;
import com.myretail.poc.entity.Product;
import com.myretail.poc.entity.ProductWithPrice;
import com.myretail.poc.service.PriceService;
import com.myretail.poc.service.ProductService;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import reactor.core.publisher.Mono;



@WebFluxTest(controllers=ProductsController.class)
@ExtendWith(SpringExtension.class)
public class ProductsControllerTest {
	
	@Autowired
	WebTestClient webTestClient ;
//	
	@MockBean
	private PriceService priceService;
	
	@MockBean
	private ProductService productService ;
//	
	
	@Test()
	@DisplayName("Should get a Product By Id")
	public void getProductById() {
		Product product = new Product(1, "Mock Product 1") ;
		Price price = new Price(1, 1, "USD") ;
		ProductWithPrice productWithPrice = new ProductWithPrice(product, price) ;
		
		when(productService.getProduct(ArgumentMatchers.any())).thenReturn(Mono.just(product)) ;
		when(priceService.getPrice(ArgumentMatchers.any())).thenReturn(Mono.just(price)) ;
		
		webTestClient.get().uri("/products/1").exchange()
		.expectStatus().isOk()
		.expectBody(ProductWithPrice.class); 
		
	}

}
