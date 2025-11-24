package com.tpibakend.tarifa_service.application;

import com.tpibakend.tarifa_service.domain.port.in.EstimatedCostUseCase;
import com.tpibakend.tarifa_service.domain.port.in.FindCurrentTariffUseCase;
import com.tpibakend.tarifa_service.infraestructure.controller.dto.TariffResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TariffService {
    FindCurrentTariffUseCase findCurrentTariffUseCase;
    EstimatedCostUseCase estimatedCostUseCase;

    public TariffResponse getCurrentTariff() {
        return mapper.toTariffResponse(findCurrentTariffUseCase.execute());
    }
    public List<TariffResponse> getAll(){
        return findCurrentTariffUseCase.findAll().stream().map(mapper::toTariffResponse).toList();
    }

    public BigDecimal estimatedCost(Double averageDistance, Double contVol, Double contWeight, Double consumoProm) {
        return estimatedCostUseCase.execute(averageDistance, contVol, contWeight, consumoProm);
    }
}
