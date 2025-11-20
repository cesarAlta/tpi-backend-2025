package com.tpibakend.solicitud_service.domain.port.in;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;

import java.util.List;

public interface FindRequestUseCase {
    Request findById(Long id);
    List<Request> findAll();

}
