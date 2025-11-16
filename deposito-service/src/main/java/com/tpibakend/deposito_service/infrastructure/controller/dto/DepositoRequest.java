package com.tpibakend.deposito_service.infrastructure.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DepositoRequest(
        @NotBlank(message = "El nombre es requerido")
        String name,

        @NotBlank(message = "La dirección es requerida")
        String address,

        @NotNull(message = "La latitud es requerida")
        BigDecimal latitude,

        @NotNull(message = "La longitud es requerida")
        BigDecimal longitude,

        @NotNull(message = "El costo diario es requerido")
        BigDecimal dailyStorageCost
) {}
