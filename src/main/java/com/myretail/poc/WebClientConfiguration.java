package com.myretail.poc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
	
	@Bean
	public WebClient webClient() {
		String baseURI = "http://localhost:8080/remote" ;
		return WebClient.builder().baseUrl(baseURI).build() ;
		
	}

}
