package com.tpibackend.ruta_service.infrastructure.controller.dto;

import java.math.BigDecimal;

public record KmTiempoEstimadoConsumoProm (Double distanceKm, String timeMinutes, BigDecimal consumoPromedio){
}
