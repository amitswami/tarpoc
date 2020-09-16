package com.myretail.poc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.myretail.poc.WebClientConfiguration;
import com.myretail.poc.entity.Product;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@Import({WebClientConfiguration.class, ProductService.class})
public class ProductServiceTest {
	
	@MockBean
	private WebClient client;
	
	@Autowired
	ProductService productService ;
	
	
	@Test
	@DisplayName("Should get product from product API")
	public void getProduct() {

		Product  mockProduct = new Product(1L, "Mock Product");

		RequestHeadersUriSpec requestHeadersUriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
		when(client.get()).thenReturn(requestHeadersUriSpecMock);
		WebClient.RequestHeadersSpec reuestHEaderSpec = Mockito.mock(WebClient.RequestHeadersSpec.class);
		when(requestHeadersUriSpecMock.uri(ArgumentMatchers.anyString())).thenReturn(reuestHEaderSpec);
		ResponseSpec value = Mockito.mock(ResponseSpec.class);
		when(reuestHEaderSpec.retrieve()).thenReturn(value);
		when(value.bodyToMono(Product.class)).thenReturn(Mono.just(mockProduct));
		
		Mono<Product> actualProduct = productService.getProduct(1);
		assertEquals(1L, actualProduct.block().getId());
		
		
		

	}

}
