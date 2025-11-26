package com.tpibakend.tarifa_service.application.usecase;

import com.tpibakend.tarifa_service.domain.Tariff;
import com.tpibakend.tarifa_service.domain.port.in.EstimatedCostUseCase;
import com.tpibakend.tarifa_service.domain.port.out.TariffRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EstimatedCostUseCaseImp implements EstimatedCostUseCase {
    TariffRepositoryPort repositoryPort;

    @Override
    public BigDecimal execute(Double averageDistance, Double contVol, Double contWeight, Double consumoProm) {
        Tariff currentTariff = repositoryPort.findLatestTariffByWeightAndVol(
                BigDecimal.valueOf(contWeight),
                BigDecimal.valueOf(contVol)
        );

        BigDecimal costPerKm = currentTariff.getBaseCostPerKm().multiply(BigDecimal.valueOf(averageDistance));
        BigDecimal costPerLiter = currentTariff.getFuelPricePerLiter().multiply(BigDecimal.valueOf(consumoProm));
        return costPerKm.add(costPerLiter);
    }
}
