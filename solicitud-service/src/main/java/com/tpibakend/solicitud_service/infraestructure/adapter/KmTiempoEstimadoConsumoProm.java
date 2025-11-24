package com.tpibakend.solicitud_service.infraestructure.adapter;


import java.math.BigDecimal;

public record KmTiempoEstimadoConsumoProm(Double distanceKm, Integer timeMinutes, BigDecimal consumoPromedio) {
}
