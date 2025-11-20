package com.tpibackend.cliente_service.application.usecase;

import com.tpibackend.cliente_service.application.exception.ClientException;
import com.tpibackend.cliente_service.domain.Client;
import com.tpibackend.cliente_service.domain.port.in.FindClientUseCase;
import com.tpibackend.cliente_service.domain.port.out.ClientRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class FindClientUseCaseImpl implements FindClientUseCase {
    ClientRepositoryPort clientRepositoryPort;
    @Override
    public List<Client> findAll() {
        return clientRepositoryPort.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepositoryPort.findById(id).orElseThrow(()-> new ClientException("CLIENT_NOT_FOUND"));
    }
}
