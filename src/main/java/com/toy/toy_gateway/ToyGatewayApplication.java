package com.toy.toy_gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ToyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyGatewayApplication.class, args);
	}

}
