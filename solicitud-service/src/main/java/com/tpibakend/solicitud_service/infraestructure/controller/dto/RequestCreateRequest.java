package com.tpibakend.solicitud_service.infraestructure.controller.dto;

import java.math.BigDecimal;

public record RequestCreateRequest(
        String clientDocument,
        String clientName,
        String clientEmail,
        String clientPhone,
        BigDecimal containerWeight,
        BigDecimal containerVolume,
        BigDecimal originLat,
        BigDecimal originLng,
        String originAddress,
        BigDecimal destinationLat,
        BigDecimal destinationLng,
        String destinationAddress
) {
}
