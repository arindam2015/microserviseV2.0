package com.microservice.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger=Logger.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
   // @Retry(name="sample-api", fallbackMethod = "fallBackResponse")
    //@CircuitBreaker(name="dafault", fallbackMethod = "fallBackResponse")
    @RateLimiter(name="default")// 10s 1000 calls to sample-api
	public String getSampleData() {
    	logger.info("Sample API Call Received!!!");
    	/*ResponseEntity<String> response=new RestTemplate().
    			getForEntity("http://localhost:8080/sampleDemo", String.class);
		return response.getBody();*/
    	return "sample-api";
	}
    public String fallBackResponse(Exception ex) {
    	return "fallback Response";
    }
}
