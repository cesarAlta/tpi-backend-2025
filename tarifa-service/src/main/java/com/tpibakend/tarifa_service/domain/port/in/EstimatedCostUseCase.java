package com.tpibakend.tarifa_service.domain.port.in;

import java.math.BigDecimal;

public interface EstimatedCostUseCase {
    BigDecimal execute(
            Double averageDistance, Double contVol, Double contWeight, Double consumoProm
    );
}
