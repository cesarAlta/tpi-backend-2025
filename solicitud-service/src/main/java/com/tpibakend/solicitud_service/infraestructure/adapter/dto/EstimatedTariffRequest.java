package com.tpibakend.solicitud_service.infraestructure.adapter.dto;

import java.math.BigDecimal;

public record EstimatedTariffRequest(
        BigDecimal containerWeight,
        BigDecimal containerVolume,
        Double averageDistance,
        Integer time,
        BigDecimal consumoPromedioGeneral
) {
}
