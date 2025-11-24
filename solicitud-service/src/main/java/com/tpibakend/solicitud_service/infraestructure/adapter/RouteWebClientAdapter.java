package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.tpibakend.solicitud_service.domain.port.out.RouteServicePort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.OriginDestination;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RouteWebClientAdapter implements RouteServicePort {
    RestClient restClient;

    public RouteWebClientAdapter(@Qualifier("routeServiceClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public KmTiempoEstimadoConsumoProm getDistanciaDirecta(OriginDestination originDestination) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/distancia-directa")
                        .queryParam("origenLat", originDestination.originLat())
                        .queryParam("origenLon", originDestination.originLng())
                        .queryParam("destinoLat", originDestination.destinationLat())
                        .queryParam("destinoLon", originDestination.destinationLng())
                        .build())
                .exchange((request, response) -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        return response.bodyTo(KmTiempoEstimadoConsumoProm.class);
                    } else if (response.getStatusCode().is4xxClientError()) {
                        throw new RuntimeException("Error calclulo de distancia: " + response.getStatusCode());
                    } else if (response.getStatusCode().is5xxServerError()) {
                        throw new RuntimeException("Error del servidor: " + response.getStatusCode());
                    }
                    throw new RuntimeException("Error inesperado: " + response.getStatusCode());
                });
    }
}
