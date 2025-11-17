package com.tpibackend.ruta_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.tpibackend.ruta_service.infrastructure.client")
public class RutaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RutaServiceApplication.class, args);
	}

}
