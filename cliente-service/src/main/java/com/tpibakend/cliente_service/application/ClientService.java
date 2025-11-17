package com.tpibakend.cliente_service.application;

import com.tpibakend.cliente_service.domain.Client;
import com.tpibakend.cliente_service.infraestructure.repository.SpringDataClientRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientService {
    SpringDataClientRepository springDataClientRepository;

    @Transactional
    public Client registerClient(Client client) {
        return springDataClientRepository.save(client);
    }

    public Long getByDocument(String document) {
       return springDataClientRepository.findByDocument(document).orElse(null);

    }
}

/*@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientService {

    JpaPostgresClient repository;
    ClientMapper mapper;

    @Transactional
    public Client registerClient(ClientRequest request) {

        // Validación de email duplicado
        repository.findByEmail(request.email()).ifPresent(c -> {
            throw new ClientException("El email ya está registrado");
        });

        Client client = mapper.toEntity(request);
        return repository.save(client);
    }
}*/