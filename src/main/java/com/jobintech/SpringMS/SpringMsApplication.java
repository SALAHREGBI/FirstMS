package com.jobintech.SpringMS;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsApplication.class, args);
	}
}