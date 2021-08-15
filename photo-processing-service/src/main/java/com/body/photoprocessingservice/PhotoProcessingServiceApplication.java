package com.body.photoprocessingservice;

import com.body.photoprocessingservice.service.BodyProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class PhotoProcessingServiceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args){
		SpringApplication.run(PhotoProcessingServiceApplication.class, args);
	}

}

@Component
class CommandLineAppStartupRunner implements CommandLineRunner {
	@Autowired
	private BodyProcessing myService;

	@Override
	public void run(String...args) throws Exception {
		myService.photoProcessing();
	}
}
