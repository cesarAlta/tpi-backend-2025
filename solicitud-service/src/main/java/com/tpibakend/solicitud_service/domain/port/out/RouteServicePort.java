package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.KmTiempoEstimadoConsumoProm;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.OriginDestination;

public interface RouteServicePort {
    KmTiempoEstimadoConsumoProm getDistanciaDirecta(OriginDestination request);
}
