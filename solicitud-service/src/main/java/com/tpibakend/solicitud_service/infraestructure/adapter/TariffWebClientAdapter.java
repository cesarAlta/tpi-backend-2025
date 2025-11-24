package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.tpibakend.solicitud_service.domain.port.out.TariffServicePort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.EstimatedTariffResponse;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.EstimatedTariffRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;


@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TariffWebClientAdapter implements TariffServicePort {

    RestClient restClient;

    public TariffWebClientAdapter(@Qualifier("tariffServiceClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public EstimatedTariffResponse getEstimatedRate(EstimatedTariffRequest tariffRequest) {
        return restClient.get().uri(uriBuilder -> uriBuilder
                        .path("/estimated-cost")
                        .queryParam("averageDistance", tariffRequest.averageDistance())
                        .queryParam("contVol", tariffRequest.containerVolume())
                        .queryParam("contWeight", tariffRequest.containerWeight())
                        .queryParam("consumoProm", tariffRequest.consumoPromedioGeneral())
                        .build())
                .exchange((request, response) -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        return response.bodyTo(EstimatedTariffResponse.class);
                    } else if (response.getStatusCode().is4xxClientError()) {
                        throw new RuntimeException("Error del calculo de tarifa: " + response.getStatusCode());
                    } else if (response.getStatusCode().is5xxServerError()) {
                        throw new RuntimeException("Error del servidor: " + response.getStatusCode());
                    }
                    throw new RuntimeException("Error inesperado: " + response.getStatusCode());
                });
    }
}
