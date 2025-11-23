package com.tpibakend.tarifa_service.domain.port.in;

import com.tpibakend.tarifa_service.domain.Tariff;

import java.util.List;

public interface FindCurrentTariffUseCase {
    Tariff execute();
List<Tariff> findAll();
}
