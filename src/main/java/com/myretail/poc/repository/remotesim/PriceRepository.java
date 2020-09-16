package com.myretail.poc.repository.remotesim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myretail.poc.entity.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long>{
	

}
