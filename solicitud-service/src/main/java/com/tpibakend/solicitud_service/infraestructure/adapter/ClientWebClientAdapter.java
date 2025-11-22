package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.tpibakend.solicitud_service.domain.port.out.ClientWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.oauth2.jwt.Jwt;
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
    public Long createClient(ClientCreateRequest request) {
        JsonNode res = restClient.post()
                .body(request)
                .retrieve()
                .body(JsonNode.class);
        if (!res.has("clientId") || (res.has("clientId") && res.get("clientId").isNull())) {
            // Manejar el error según sea necesario
        }
        return res.get("clientId").asLong();

    }

    @Override
    public Optional<Long> getClientIdByKeycloakId(String keycloakId) {
        return restClient.get()
                .uri("/keycloak/{keycloakId}", keycloakId)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        JsonNode jsonNode = response.bodyTo(JsonNode.class);
                        return Optional.of(jsonNode.get("clientId").asLong());
                    } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                        return Optional.empty();
                    } else if (response.getStatusCode().is4xxClientError()) {
                        throw new RuntimeException("Error del cliente: " + response.getStatusCode());
                    } else if (response.getStatusCode().is5xxServerError()) {
                        throw new RuntimeException("Error del servidor: " + response.getStatusCode());
                    }
                    throw new RuntimeException("Error inesperado: " + response.getStatusCode());
                });
    }
}
