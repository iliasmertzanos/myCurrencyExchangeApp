package com.microservice.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currencyexchangeservice.bean.ExchangeRatio;

public interface ExchangeRatioRepository 
	extends JpaRepository<ExchangeRatio, Long>{
	
	ExchangeRatio findByFromAndTo(String from, String to);

}
