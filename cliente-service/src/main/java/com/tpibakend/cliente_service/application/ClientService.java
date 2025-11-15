package com.tpibakend.cliente_service.application;

import com.tpibakend.cliente_service.domain.Client;
import com.tpibakend.cliente_service.infraestructure.repository.JpaPostgresClient;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientService {
    JpaPostgresClient jpaPostgresClient;

    @Transactional
    public Client registerClient(Client client) {
        return jpaPostgresClient.save(client);
    }
}
