package com.nikhil.microservice.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CircuitBreakerController {

	@GetMapping("/sampleapi")
//	@Retry(name = "default", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String sampleAPI() {
		log.info("Sample API call received");
		new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return "Sample API";
	}
	
	public String hardcodedResponse(Exception e) {
		return "fallback-response";
	}
}
