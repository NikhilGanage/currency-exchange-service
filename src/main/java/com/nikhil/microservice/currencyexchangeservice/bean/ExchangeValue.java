package com.nikhil.microservice.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {

	@Id
	private Long id;
	
	@Column(name = "from_currency")
	private String fromCurrency;
	
	@Column(name="to_currency")
	private String toCurrency;
	
	@Column(name="multiple")
	private BigDecimal conversionMultiple;
	
	private int port;
}
