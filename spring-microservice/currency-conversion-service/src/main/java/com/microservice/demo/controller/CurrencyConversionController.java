package com.microservice.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.demo.bean.CurrencyConversion;
import com.microservice.demo.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	@Autowired
	CurrencyExchangeProxy currencyProxy;
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion getCurrencyConversion(@PathVariable String from,
		  @PathVariable String to,@PathVariable BigDecimal quantity) {
		//Invoking currency-exchange service from currency conversion service through RestTemplate
		HashMap<String,String> uriVariable=new HashMap<>();
		uriVariable.put("from",from);
		uriVariable.put("to",to);
		ResponseEntity<CurrencyConversion> currencyConversionResponse=new RestTemplate().getForEntity
				("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversion.class,uriVariable);
		CurrencyConversion currencyConversion=currencyConversionResponse.getBody();
		//System.out.println(currencyConversion.getFrom());
		  return new CurrencyConversion(currencyConversion.getId(),
				  from,to,quantity,
				  currencyConversion.getConversionMultiple(),
				  quantity.multiply(currencyConversion.getConversionMultiple()),
				  currencyConversion.getEnvironment());
	  
  }
	
	@GetMapping("/currency-conversion-feignClient/from/{from}/to/{to}/quantity/{quantity}")
	  public CurrencyConversion getCurrencyConversionUsingFeignClient(@PathVariable String from,
			  @PathVariable String to,@PathVariable BigDecimal quantity) {
			//Invoking currency-exchange service from currency conversion service through feign
			CurrencyConversion currencyConversion=currencyProxy.getExchangedValue(from, to);
			//System.out.println(currencyConversion.getFrom());
			  return new CurrencyConversion(currencyConversion.getId(),
					  from,to,quantity,
					  currencyConversion.getConversionMultiple(),
					  quantity.multiply(currencyConversion.getConversionMultiple()),
					  currencyConversion.getEnvironment());
		  
	  }
}
