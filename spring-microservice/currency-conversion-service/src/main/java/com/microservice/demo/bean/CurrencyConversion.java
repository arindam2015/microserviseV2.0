package com.microservice.demo.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
   private long id;
   private String from;
   private String to;
   private BigDecimal quantity;
   private BigDecimal conversionMultiple;
   private BigDecimal totalCurrencyValue;
   private String environment;
   public CurrencyConversion() {
	   
   }
public CurrencyConversion(long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
		BigDecimal totalCurrencyValue, String environment) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.quantity = quantity;
	this.conversionMultiple = conversionMultiple;
	this.totalCurrencyValue = totalCurrencyValue;
	this.environment = environment;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public BigDecimal getQuantity() {
	return quantity;
}
public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
}

public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public BigDecimal getConversionMultiple() {
	return conversionMultiple;
}
public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
}
public BigDecimal getTotalCurrencyValue() {
	return totalCurrencyValue;
}
public void setTotalCurrencyValue(BigDecimal totalCurrencyValue) {
	this.totalCurrencyValue = totalCurrencyValue;
}
public String getEnvironment() {
	return environment;
}
public void setEnvironment(String environment) {
	this.environment = environment;
}
   
}
