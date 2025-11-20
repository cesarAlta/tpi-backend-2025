package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.domain.Request;

import java.util.List;
import java.util.Optional;

public interface RequestRepositoryPort {
    Request save(Request request);
    Optional<Request> findById(Long id);
    List<Request> findAll();
}
