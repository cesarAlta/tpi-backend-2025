package com.tpibackend.ruta_service.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SegmentoRequestDTO {

    private Long rutaId;

    private String originType;

    private BigDecimal originLat;
    private BigDecimal originLng;

    private BigDecimal destLat;
    private BigDecimal destLng;

    private String segmentType;

    private BigDecimal estimatedDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    private Long truckId;
}