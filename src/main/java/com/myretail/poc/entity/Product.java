package com.myretail.poc.entity;

public class Product {
	private Number id; 
	private String name;
		
	public Product() {
		
	}
	public Product(Number id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
