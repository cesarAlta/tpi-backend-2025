package com.tpibakend.solicitud_service.domain.port.in;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CreateRequestUseCase {
    Request execute(RequestCreateRequest requestCreateRequest, Jwt jwt);
}
