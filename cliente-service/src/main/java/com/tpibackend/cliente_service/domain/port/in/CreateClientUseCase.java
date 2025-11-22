package com.tpibackend.cliente_service.domain.port.in;

import com.tpibackend.cliente_service.domain.Client;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientRequest;

public interface CreateClientUseCase {
    Client execute(String name, String email, String document, String phone, String keycloakId);
}
