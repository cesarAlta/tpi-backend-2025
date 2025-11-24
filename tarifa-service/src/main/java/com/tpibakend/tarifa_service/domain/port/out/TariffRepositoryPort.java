package com.tpibakend.tarifa_service.domain.port.out;

import com.tpibakend.tarifa_service.domain.Tariff;

import java.math.BigDecimal;
import java.util.List;

public interface TariffRepositoryPort {
    Tariff getCurrentTariff();
    List<Tariff> findAll();

    Tariff findLatestTariffByWeightAndVol(BigDecimal contWeight, BigDecimal contVol);
}
