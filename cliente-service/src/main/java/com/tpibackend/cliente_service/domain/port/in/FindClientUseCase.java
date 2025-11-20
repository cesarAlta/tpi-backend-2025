package com.tpibackend.cliente_service.domain.port.in;

import com.tpibackend.cliente_service.domain.Client;

import java.util.List;
import java.util.Optional;

public interface FindClientUseCase {
    List<Client> findAll();
    Client findById(Long id);

}
