package com.tpibakend.contenedor_service.infraestructure.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContainerRequest(
        @NotNull(message = "El campo peso es obligatorio")
        BigDecimal weightKg,
        @NotNull(message = "El campo volumen es obligatorio")
        BigDecimal volumeM3,
        @NotNull(message = "El campo cliente es obligatorio")
        Long clientId) {
}