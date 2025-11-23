package com.tpibakend.tarifa_service.application;

import com.tpibakend.tarifa_service.domain.port.in.FindCurrentTariffUseCase;
import com.tpibakend.tarifa_service.infraestructure.controller.dto.TariffResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TariffService {
    FindCurrentTariffUseCase findCurrentTariffUseCase;

    public TariffResponse getCurrentTariff() {
        return mapper.toTariffResponse(findCurrentTariffUseCase.execute());
    }
    public List<TariffResponse> getAll(){
        return findCurrentTariffUseCase.findAll().stream().map(mapper::toTariffResponse).toList();
    }
}
