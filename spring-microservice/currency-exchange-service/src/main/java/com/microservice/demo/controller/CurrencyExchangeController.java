package com.microservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.bean.CurrencyExchanged;
import com.microservice.demo.repository.CurrencyExchangeRepo;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment environment;
	@Autowired
	CurrencyExchangeRepo currencyExchangedRepo;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyExchanged getExchangedValue(@PathVariable("from") String from,
		  @PathVariable("to") String to) {
	  //CurrencyExchanged currencyExchanged= new CurrencyExchanged(1000L,form,to,BigDecimal.valueOf(65));
		CurrencyExchanged currencyExchanged=currencyExchangedRepo.findByFromAndTo(from, to);
		if(currencyExchanged==null) {
			throw new RuntimeException("No data Found!!!");
		}
		String port=environment.getProperty("local.server.port");
      currencyExchanged.setEnvironment(port);
	  return currencyExchanged;
	}
}
