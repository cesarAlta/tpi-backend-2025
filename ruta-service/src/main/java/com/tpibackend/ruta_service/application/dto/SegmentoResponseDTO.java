package com.tpibackend.ruta_service.application.dto;

import com.tpibackend.ruta_service.domain.model.Segmento;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SegmentoResponseDTO {

    private Long segmentoId;
    private Long rutaId;

    private String originType;

    private BigDecimal originLat;
    private BigDecimal originLng;

    private BigDecimal destLat;
    private BigDecimal destLng;

    private String segmentType;
    private String status;

    private BigDecimal estimatedDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    private BigDecimal actualDistanceKm;
    private Integer actualTimeMin;
    private BigDecimal actualCost;

    private Long truckId;

    public static SegmentoResponseDTO from(Segmento s) {
        SegmentoResponseDTO dto = new SegmentoResponseDTO();

        dto.setSegmentoId(s.getSegmentoId());
        dto.setRutaId(s.getRuta().getRutaId());

        dto.setOriginType(s.getOriginType());
        dto.setOriginLat(s.getOriginLat());
        dto.setOriginLng(s.getOriginLng());
        dto.setDestLat(s.getDestLat());
        dto.setDestLng(s.getDestLng());

        dto.setSegmentType(s.getSegmentType());
        dto.setStatus(s.getStatus());

        dto.setEstimatedDistanceKm(s.getEstimatedDistanceKm());
        dto.setEstimatedTimeMin(s.getEstimatedTimeMin());
        dto.setEstimatedCost(s.getEstimatedCost());

        dto.setActualDistanceKm(s.getActualDistanceKm());
        dto.setActualTimeMin(s.getActualTimeMin());
        dto.setActualCost(s.getActualCost());

        dto.setTruckId(s.getTruckId());

        return dto;
    }
}