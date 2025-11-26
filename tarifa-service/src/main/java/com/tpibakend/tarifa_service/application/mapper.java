package com.tpibakend.tarifa_service.application;

import com.tpibakend.tarifa_service.domain.Tariff;
import com.tpibakend.tarifa_service.infraestructure.controller.dto.TariffResponse;

public class mapper {
    public static TariffResponse toTariffResponse(Tariff tariff) {
        return tariff == null
                ? null
                : new TariffResponse(
                tariff.getTariffId(),
                tariff.getBaseCostPerKm(),
                tariff.getVolumeRangeMin(),
                tariff.getVolumeRangeMax(),
                tariff.getWeightRangeMin(),
                tariff.getWeightRangeMax(),
                tariff.getStorageCostPerDay(),
                tariff.getFuelPricePerLiter(),
                tariff.getFixedPricePerSection(),
                tariff.getCreatedAt()
        );
    }
}
