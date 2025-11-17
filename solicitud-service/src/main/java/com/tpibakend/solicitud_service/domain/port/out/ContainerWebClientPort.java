package com.tpibakend.solicitud_service.domain.port.out;

import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateContainerRequest;

import java.math.BigDecimal;

public interface ContainerWebClientPort {
    Long createContainer(CreateContainerRequest request);
}
