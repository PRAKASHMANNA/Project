package com.esop.ag.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {

   @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
	   return builder.routes()
	   .route("esop_grant", r -> r.path("/grant/**")
	            .filters(f -> f.stripPrefix(1)
	            		.circuitBreaker(c -> c
	                            .setName("circuitBreaker")
	                            .setFallbackUri("forward:/grantsFallBack")))
	            .uri("http://localhost:8082")) 
	        .route("esop_plan", r -> r.path("/esop/**")
	            .filters(f -> f.stripPrefix(1))
	            .uri("http://localhost:8081"))
	        .build();
	   
    }
}
