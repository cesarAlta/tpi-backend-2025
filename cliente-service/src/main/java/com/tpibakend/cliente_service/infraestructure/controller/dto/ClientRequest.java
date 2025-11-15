package com.tpibakend.cliente_service.infraestructure.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientRequest(
        @NotBlank(message = "El nombre es requerido")
        String name,
        @NotBlank(message = "El email es requerido")

        String email,
        String phone
) {
}
