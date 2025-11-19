package com.tpibackend.ruta_service.infrastructure.controller.dto;

import lombok.Data;

@Data
public class SegmentoRequest {
    private Long rutaId;
    private String origenTexto;
    private String destinoTexto;
    private Double distanciaKm;
}