package com.tpibackend.contenedor_service.infraestructure.controller.dto;

import java.math.BigDecimal;

public record ContainerResponse(
        Long id,
        String code,
        BigDecimal weightKg,
        BigDecimal volumeM3,
        Long clientId
) {
}
