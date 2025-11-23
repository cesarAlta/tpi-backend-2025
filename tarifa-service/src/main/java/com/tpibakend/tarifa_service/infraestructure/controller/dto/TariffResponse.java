package com.tpibakend.tarifa_service.infraestructure.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TariffResponse(
        Long tariffId,
        BigDecimal baseCostPerKm,
        BigDecimal volumeRangeMin,
        BigDecimal volumeRangeMax,
        BigDecimal weightRangeMin,
        BigDecimal weightRangeMax,
        BigDecimal storageCostPerDay,
        BigDecimal fuelPricePerLiter,
        BigDecimal fixedChargePerSection,
        LocalDateTime createdAt
) {
}
