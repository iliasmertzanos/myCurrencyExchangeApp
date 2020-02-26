package com.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyexchangeservice.bean.ExchangeRatio;
import com.microservice.currencyexchangeservice.dao.ExchangeRatioRepository;


@RestController
public class CurrencyExchangeController {
	private Logger logger=LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	ExchangeRatioRepository myExchangeValueRepo;
	
	@Autowired
	private Environment enviroment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeRatio retrieveExchangeRatio(@PathVariable String from,
			@PathVariable String to) {
		ExchangeRatio myExchangeRatio=myExchangeValueRepo.findByFromAndTo(from, to);
		myExchangeRatio.setPort(Integer.parseInt(this.enviroment.getProperty("local.server.port")));
		logger.info("{}",myExchangeRatio);
		return myExchangeRatio;
	}

}
