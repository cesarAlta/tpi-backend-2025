package com.tpibakend.cliente_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteServiceApplication.class, args);
	}

}

/*package com.tpibakend.cliente_service.application;

import com.tpibakend.cliente_service.domain.Client;
import com.tpibakend.cliente_service.infraestructure.controller.dto.ClientRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

	public Client toEntity(ClientRequest req) {
		Client client = new Client();
		client.setName(req.name());
		client.setEmail(req.email());
		client.setPhone(req.phone());
		return client;
	}
}*/
