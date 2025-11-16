package com.tpibakend.deposito_service.application.impl;

import com.tpibakend.deposito_service.application.DepositoService;
import com.tpibakend.deposito_service.application.exception.DepositoException;
import com.tpibakend.deposito_service.domain.Deposito;
import com.tpibakend.deposito_service.infrastructure.controller.dto.DepositoRequest;
import com.tpibakend.deposito_service.infrastructure.repository.JpaPostgresDeposito;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DepositoServiceImpl implements DepositoService {

    JpaPostgresDeposito depositoRepository;

    @Override
    public Deposito registrarDeposito(DepositoRequest request) {

        Deposito deposito = Deposito.builder()
                .name(request.name())
                .address(request.address())
                .latitude(request.latitude())
                .longitude(request.longitude())
                .dailyStorageCost(request.dailyStorageCost())
                .createdAt(LocalDateTime.now())
                .build();

        return depositoRepository.save(deposito);
    }

    @Override
    public Deposito obtenerDeposito(Long id) {
        return depositoRepository.findById(id)
                .orElseThrow(() -> new DepositoException("Depósito no encontrado"));
    }

    @Override
    public List<Deposito> listarDepositos() {
        return depositoRepository.findAll();
    }
}
