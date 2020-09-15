package com.myretail.poc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name"})
public class ProductWithPrice {
	Price price; 
	Product product ;
	
	public ProductWithPrice() {
		
	}
	
	public ProductWithPrice(Product product, Price price) {
		super();
		this.price = price;
		this.product = product;
	}

	@JsonProperty("current_price")
	public Price getCurrentPrice() { 
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Number getId() {
		return product.getId() ;
	}
	
	public String getName() {
		return product.getName() ;
	}
	
	
	
	

}
