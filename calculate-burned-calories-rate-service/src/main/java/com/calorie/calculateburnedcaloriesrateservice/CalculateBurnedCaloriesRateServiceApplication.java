package com.calorie.calculateburnedcaloriesrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient (name = "CalculateBurnedCaloriesRate")
public class CalculateBurnedCaloriesRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateBurnedCaloriesRateServiceApplication.class, args);
	}

}
