package com.esop.ag.config;

import java.lang.module.ModuleDescriptor.Builder;
import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

@Configuration
public class CircuitBreakerConfig {
     
	@Bean
	public CircuitBreakerConfigCustomizer circuitconfig() {
		return CircuitBreakerConfigCustomizer.of("circuitBreaker", Builder->Builder.failureRateThreshold(50)
				.slidingWindowSize(5)
				.minimumNumberOfCalls(3)
				.maxWaitDurationInHalfOpenState(Duration.ofSeconds(10))
				.permittedNumberOfCallsInHalfOpenState(3)
				.automaticTransitionFromOpenToHalfOpenEnabled(true));
	}
}
