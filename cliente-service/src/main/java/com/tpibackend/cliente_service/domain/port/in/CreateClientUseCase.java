package com.tpibackend.cliente_service.domain.port.in;

public interface CreateClientUseCase {
    Long execute(String name, String email, String document, String phone);
}
