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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductWithPrice other = (ProductWithPrice) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductWithPrice [price=" + price + ", product=" + product + "]";
	}
	
	

}
