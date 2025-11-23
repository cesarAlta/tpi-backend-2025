package com.tpibakend.tarifa_service.application.usecase;

import com.tpibakend.tarifa_service.domain.Tariff;
import com.tpibakend.tarifa_service.domain.port.in.FindCurrentTariffUseCase;
import com.tpibakend.tarifa_service.domain.port.out.TariffRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class getCurrentTariffUseCaseImp implements FindCurrentTariffUseCase {

    TariffRepositoryPort repositoryPort;

    @Override
    public Tariff execute() {
        return repositoryPort.getCurrentTariff();
    }

    @Override
    public List<Tariff> findAll() {
        return repositoryPort.findAll();
    }
}
