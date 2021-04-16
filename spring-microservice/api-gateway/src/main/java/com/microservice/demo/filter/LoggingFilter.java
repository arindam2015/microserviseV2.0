package com.microservice.demo.filter;

import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;
@Component
public class LoggingFilter implements GlobalFilter {
   private Logger logger=org.slf4j.LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Inside Logging Filter");
		logger.info("Path of the requaet received:"+exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
