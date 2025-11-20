package com.tpibackend.cliente_service.infrastructure.controller.dto;

import java.time.LocalDateTime;

public record ClientResponse(
        Long id,
        String name,
        String email,
        String document,
        String phone,
        LocalDateTime createdAt
) {
}
