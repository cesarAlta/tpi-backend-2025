package com.tpibakend.solicitud_service.infraestructure.adapter.dto;

public record ClientCreateRequest(
        String name,
        String document,
        String email,
        String phone,
        String keycloakId) {
}
