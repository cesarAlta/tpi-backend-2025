package com.tpibackend.cliente_service.application.usecase;

import com.tpibackend.cliente_service.domain.Client;
import com.tpibackend.cliente_service.domain.port.in.CreateClientUseCase;
import com.tpibackend.cliente_service.domain.port.out.ClientRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    ClientRepositoryPort clientRepositoryPort;

    @Override
    public Client execute(String name, String email, String document, String phone, String keycloakId) {
       return clientRepositoryPort.save(Client.createNew(name,email,document,phone, keycloakId));

    }



}
