package com.tpibackend.ruta_service.infrastructure.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SegmentoResponse {
    private Long id;
    private Long rutaId;
    private String originType;
    private BigDecimal originLat;
    private BigDecimal originLng;
    private BigDecimal destLat;
    private BigDecimal destLng;
    private String segmentType;
    private BigDecimal estimatedDistanceKm;
    private String status;
}

/*
public class SegmentoResponse {
    private Long id;
    private Long rutaId;
    private String origenTexto;
    private String destinoTexto;
    private Double distanciaKm;
}*/