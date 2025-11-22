package com.tpibackend.cliente_service.domain.port.out;

import com.tpibackend.cliente_service.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Optional<Client> findByKeycloakId(String keycloakId);
}
