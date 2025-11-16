package com.example.solicitudservice.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SolicitudRequestDTO {

    private Long clientId;
    private Long containerId;

    // Datos de ubicación no persistidos
    private String origenTexto;
    private Double origenLat;
    private Double origenLng;

    private String destinoTexto; // opcional
    private Double destinoLat;
    private Double destinoLng;
}