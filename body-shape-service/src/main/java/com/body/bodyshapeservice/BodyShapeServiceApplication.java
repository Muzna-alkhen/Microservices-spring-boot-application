package com.body.bodyshapeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableAspectJAutoProxy
public class BodyShapeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodyShapeServiceApplication.class, args);
	}

    @LoadBalanced
    @Bean
    RestTemplate restTemplate()
    {return new RestTemplate();}
}
