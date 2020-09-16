package com.myretail.poc.repository.remotesim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myretail.poc.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	

}
