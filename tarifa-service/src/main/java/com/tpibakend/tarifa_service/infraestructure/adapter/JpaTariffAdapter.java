package com.tpibakend.tarifa_service.infraestructure.adapter;

import com.tpibakend.tarifa_service.domain.Tariff;
import com.tpibakend.tarifa_service.domain.port.out.TariffRepositoryPort;
import com.tpibakend.tarifa_service.infraestructure.persistence.SpringDataTariff;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JpaTariffAdapter implements TariffRepositoryPort {
    SpringDataTariff springDataTariff;

    @Override
    public Tariff getCurrentTariff() {
        return springDataTariff.findTopByOrderByCreatedAtDesc();
    }

    @Override
    public List<Tariff> findAll() {
        return springDataTariff.findAll();
    }

    @Override
    public Tariff findLatestTariffByWeightAndVol(BigDecimal contWeight, BigDecimal contVol) {
        return springDataTariff.findLatestTariffByWeightAndVol(contWeight, contVol);
    }
}
