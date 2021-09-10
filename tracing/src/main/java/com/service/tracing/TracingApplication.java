package com.service.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.service.tracing.config","com.service.tracing.controller","com.service.tracing.service"})
@EntityScan(basePackages = {"com.service.tracing.entity"})
@EnableJpaRepositories(basePackages = {"com.service.tracing.repo"})
public class TracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracingApplication.class, args);
	}

}
