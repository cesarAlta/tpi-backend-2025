package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.dto.EstimatedTariffResponse;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.EstimatedTariffRequest;

public interface TariffServicePort {
    EstimatedTariffResponse getEstimatedRate(EstimatedTariffRequest request);
}
