package com.tpibakend.solicitud_service.application.usecase;

import java.math.BigDecimal;

public record ParametersFoRates(Double averageDistance,
                                Integer StorageDays,
                                BigDecimal consumoPromedioGeneral) {
}
