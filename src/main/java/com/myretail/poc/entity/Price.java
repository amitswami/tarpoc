package com.myretail.poc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"value"})
public class Price {
	
	private Number value ;
	private String currencyCode ;
	
	public Price() {
		
	}
	public Price(Number value, String currencyCode) {
		super();
		this.value = value;
		this.currencyCode = currencyCode;
	}
	public Number getValue() {
		return value;
	}
	public void setValue(Number value) {
		this.value = value;
	}
	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
	

}
