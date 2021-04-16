package com.microservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.demo.bean.CurrencyExchanged;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchanged, Long> {
	CurrencyExchanged findByFromAndTo(String from,String to);
}
