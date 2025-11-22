package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;

import java.util.Optional;

public interface ClientWebClientPort {
    Long createClient(ClientCreateRequest request);
    Optional<Long> getClientIdByKeycloakId(String keycloakId);
}
