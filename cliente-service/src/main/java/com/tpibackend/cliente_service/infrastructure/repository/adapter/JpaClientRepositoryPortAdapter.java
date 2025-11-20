package com.tpibackend.cliente_service.infrastructure.repository.adapter;

import com.tpibackend.cliente_service.application.exception.ClientException;
import com.tpibackend.cliente_service.domain.Client;
import com.tpibackend.cliente_service.domain.port.out.ClientRepositoryPort;
import com.tpibackend.cliente_service.infrastructure.repository.SpringDataClientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class JpaClientRepositoryPortAdapter implements ClientRepositoryPort {
    SpringDataClientRepository repository;

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Optional<Client> findByDocument(String document) {
        return repository.findByDocument(document);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }
}
