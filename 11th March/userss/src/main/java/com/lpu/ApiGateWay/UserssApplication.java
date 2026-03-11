package com.lpu.ApiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserssApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserssApplication.class, args);
	}

}
