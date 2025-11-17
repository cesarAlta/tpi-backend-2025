package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateRouteRequest;

public interface RouteWebClientPort {
    void createRoute(CreateRouteRequest request);
}
