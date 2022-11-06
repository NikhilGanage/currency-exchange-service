package com.nikhil.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.microservice.currencyexchangeservice.bean.ExchangeValue;
import com.nikhil.microservice.currencyexchangeservice.bean.ExchangeValueRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		log.info("retrieveExchangeValue called with {} to {} ",fromCurrency,toCurrency);
//		ExchangeValue exchangeValue = new ExchangeValue(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(65),0);
		ExchangeValue exchangeValue = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
