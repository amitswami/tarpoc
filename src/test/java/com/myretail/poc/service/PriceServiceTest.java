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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.myretail.poc.WebClientConfiguration;
import com.myretail.poc.entity.Price;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@Import({WebClientConfiguration.class, PriceService.class})

public class PriceServiceTest {

	@MockBean
	private WebClient priceClient;
	
	@Autowired
	PriceService priceService ;
	
	

	@Test
	@DisplayName("Should get price from price API")
	public void getPrice() {

		Price mockPrice = new Price(1L, 1D, "USD");

		RequestHeadersUriSpec requestHeadersUriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
		when(priceClient.get()).thenReturn(requestHeadersUriSpecMock);
		WebClient.RequestHeadersSpec reuestHEaderSpec = Mockito.mock(WebClient.RequestHeadersSpec.class);
		when(requestHeadersUriSpecMock.uri(ArgumentMatchers.anyString())).thenReturn(reuestHEaderSpec);
		ResponseSpec value = Mockito.mock(ResponseSpec.class);
		when(reuestHEaderSpec.retrieve()).thenReturn(value);
		when(value.bodyToMono(Price.class)).thenReturn(Mono.just(mockPrice));
		Mono<Price> actualPrice = priceService.getPrice(1);
		assertEquals(1.0, actualPrice.block().getValue());
		
		
		

	}

}
