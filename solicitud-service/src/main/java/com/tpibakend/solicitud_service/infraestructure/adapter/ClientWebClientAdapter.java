package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.tpibakend.solicitud_service.domain.port.out.ClientWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientWebClientAdapter implements ClientWebClientPort {
    RestClient restClient;

    public ClientWebClientAdapter(@Qualifier("clientServiceClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public boolean existsById(Long id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .body(Boolean.class);
    }

    @Override
    public Long createClient(ClientCreateRequest request) {
        return restClient.post()
                .body(request)
                .retrieve()
                .body(Long.class);
    }

    @Override
    public Optional<Long> getByDocument(String document) {
        Long id = restClient.get()
                .uri("/document/{document}", document)
                .retrieve()
                .body(Long.class);
        return Optional.of(id);
    }
}
