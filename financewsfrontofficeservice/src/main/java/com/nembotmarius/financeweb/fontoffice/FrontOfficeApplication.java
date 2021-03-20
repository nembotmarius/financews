package com.nembotmarius.financeweb.fontoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FrontOfficeApplication {
	public static void main(String[] args) {
		SpringApplication.run(FrontOfficeApplication.class, args);
	}
}
