package com.tpibackend.contenedor_service.domain.port.in;

import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerRequest;

public interface CreateContainerUseCase {
    Container execute(ContainerRequest containerRequest);
}
