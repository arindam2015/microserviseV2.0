package com.demo.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.limitservice.bean.Limits;
import com.demo.microservice.limitservice.configuration.LimitConfiguration;

@RestController
public class LimitServiceController {
	@Autowired
	private LimitConfiguration limitConfiguration;
	@GetMapping("/limits")
  public Limits retrieveLimits() {
	  return new Limits(limitConfiguration.getMaximum(),limitConfiguration.getMinimum());
  }
}
