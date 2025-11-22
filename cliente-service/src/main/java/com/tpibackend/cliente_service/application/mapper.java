package com.tpibackend.cliente_service.application;

import com.tpibackend.cliente_service.domain.Client;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientResponse;

public class mapper {
    public static ClientResponse toClientResponse(Client client) {
        return client == null
                ? null
                : new ClientResponse(
                client.getClientId(),
                client.getName(),
                client.getEmail(),
                client.getDocument(),
                client.getPhone(),
                client.getCreatedAt(),
                client.getKeycloakId()
        );
    }
}
