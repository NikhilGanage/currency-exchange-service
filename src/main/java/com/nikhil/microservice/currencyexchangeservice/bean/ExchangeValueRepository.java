package com.nikhil.microservice.currencyexchangeservice.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
