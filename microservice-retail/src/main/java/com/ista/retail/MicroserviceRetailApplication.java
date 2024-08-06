package com.ista.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRetailApplication.class, args);
	}

}
