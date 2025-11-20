package com.tpibackend.cliente_service.application;

import com.tpibackend.cliente_service.domain.port.in.CreateClientUseCase;
import com.tpibackend.cliente_service.domain.port.in.FindClientUseCase;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientRequest;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientResponse;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientService {

    CreateClientUseCase createClientUseCase;
    FindClientUseCase findClientUseCase;

    @Transactional
    public Long registerClient(ClientRequest client) {
        return createClientUseCase.execute(
                client.name(),
                client.email(),
                client.document(),
                client.phone()
        );
    }

    public List<ClientResponse> getAll() {
        return findClientUseCase.findAll().stream()
                .map(mapper::toClientResponse)
                .toList();
    }

    public ClientResponse getClient(Long id) {
        return mapper.toClientResponse(findClientUseCase.findById(id));
    }

    public Long getByDocument(String document) {
        return findClientUseCase.findByDocument(document).getClientId();
    }
}