package com.tpibakend.deposito_service.application;

import com.tpibakend.deposito_service.domain.Deposito;
import com.tpibakend.deposito_service.infrastructure.controller.dto.DepositoRequest;

import java.util.List;

public interface DepositoService {

    Deposito registrarDeposito(DepositoRequest request);

    Deposito obtenerDeposito(Long id);

    List<Deposito> listarDepositos();
}
