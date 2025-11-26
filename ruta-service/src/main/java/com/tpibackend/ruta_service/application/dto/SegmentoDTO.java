package com.tpibackend.ruta_service.application.dto;

import com.tpibackend.ruta_service.domain.model.Segmento;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SegmentoDTO {
    private Long segmentoId;

    private String originType;
    private BigDecimal originLat;
    private BigDecimal originLng;

    private BigDecimal destLat;
    private BigDecimal destLng;

    private String segmentType;
    private String status;

    public static SegmentoDTO from(Segmento s){
        SegmentoDTO dto = new SegmentoDTO();
        dto.setSegmentoId(s.getSegmentoId());
        dto.setOriginType(s.getOriginType());
        dto.setOriginLat(s.getOriginLat());
        dto.setOriginLng(s.getOriginLng());
        dto.setDestLat(s.getDestLat());
        dto.setDestLng(s.getDestLng());
        dto.setSegmentType(s.getSegmentType().toString());
        dto.setStatus(s.getStatus().toString());
        return dto;
    }
}