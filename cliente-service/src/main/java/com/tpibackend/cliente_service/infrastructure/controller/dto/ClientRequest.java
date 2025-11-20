package com.tpibackend.cliente_service.infrastructure.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientRequest(
        @NotBlank(message = "El nombre es requerido")
        String name,
        @NotBlank(message = "El email es requerido")
        String email,
        @NotBlank(message = "El documento es requerido")
        String document,
        String phone
) {
}
