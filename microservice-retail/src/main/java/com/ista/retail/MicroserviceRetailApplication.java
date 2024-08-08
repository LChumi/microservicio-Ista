package com.ista.retail;

import com.ista.retail.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import(OpenAPIConfiguration.class)
public class MicroserviceRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRetailApplication.class, args);
	}

}
