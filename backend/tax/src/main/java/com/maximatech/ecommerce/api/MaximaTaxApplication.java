package com.maximatech.ecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringBootApplication class for service configuration.
 * This also enables Eureka Discovery Client.
 * @author Brenno Fagundes
 */
@SpringBootApplication
@EnableEurekaClient
public class MaximaTaxApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaximaTaxApplication.class, args);
	}
}
