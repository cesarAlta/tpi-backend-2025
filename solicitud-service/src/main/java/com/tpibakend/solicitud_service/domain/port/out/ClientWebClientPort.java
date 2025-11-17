package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;

import java.util.Optional;

public interface ClientWebClientPort {
    boolean existsById(Long id);
    Long createClient(ClientCreateRequest request);
    Optional<Long> getByDocument(String s);
}
