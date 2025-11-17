package com.tpibakend.solicitud_service.infraestructure.adapter.dto;

import java.math.BigDecimal;

public record CreateRouteRequest(
        Long requestId,
        BigDecimal originLat,
        BigDecimal originLng,
        String originAddress,
        BigDecimal destinationLat,
        BigDecimal destinationLng,
        String destinationAddress
) {
}
