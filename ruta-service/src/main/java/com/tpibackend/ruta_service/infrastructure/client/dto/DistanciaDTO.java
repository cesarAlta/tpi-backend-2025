package com.tpibackend.ruta_service.infrastructure.client.dto;

import lombok.Data;

@Data
public class DistanciaDTO {
    private String origen;
    private String destino;
    private double kilometros;
    private String duracionTexto;
}