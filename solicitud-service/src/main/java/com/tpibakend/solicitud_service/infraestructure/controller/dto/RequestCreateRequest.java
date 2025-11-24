package com.tpibakend.solicitud_service.infraestructure.controller.dto;

import java.math.BigDecimal;

public record RequestCreateRequest(
        String clientDocument,
        String clientName,
        String clientEmail,
        String clientPhone,
        BigDecimal containerWeight,
        BigDecimal containerVolume,
        Double originLat,
        Double originLng,
        String originAddress,
        Double destinationLat,
        Double destinationLng,
        String destinationAddress
) {
}
