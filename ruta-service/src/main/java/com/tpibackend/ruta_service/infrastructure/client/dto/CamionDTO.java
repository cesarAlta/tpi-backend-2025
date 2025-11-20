package com.tpibackend.ruta_service.infrastructure.client.dto;

import lombok.Data;

@Data
public class CamionDTO {
    private Long id;
    private String patente;
    private String estado;
}