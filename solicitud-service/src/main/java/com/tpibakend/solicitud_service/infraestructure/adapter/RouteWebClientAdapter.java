package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.tpibakend.solicitud_service.domain.port.out.RouteWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateRouteRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class RouteWebClientAdapter implements RouteWebClientPort {
    RestClient restClient;

    public RouteWebClientAdapter(@Qualifier("routeServiceClient") RestClient restClient) {
        this.restClient = restClient;
    }
    @Override
    public void createRoute(CreateRouteRequest request) {
        restClient.post()
                .body(request)
                .retrieve()
                .body(Void.class);

    }
}
