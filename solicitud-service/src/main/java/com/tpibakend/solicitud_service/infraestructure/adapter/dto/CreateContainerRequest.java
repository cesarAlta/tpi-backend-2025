package com.tpibakend.solicitud_service.infraestructure.adapter.dto;

import java.math.BigDecimal;

public record CreateContainerRequest(BigDecimal weightKg, BigDecimal volumeM3, Long clientId) {
}
