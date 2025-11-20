package com.tpibackend.contenedor_service.application;

import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerResponse;

public class Mapper {
    public static ContainerResponse toContainerResponse(
            Container container
    ) {
        return container == null
                ? null
                : new ContainerResponse(
                container.getClientId(),
                container.getCode(),
                container.getWeightKg(),
                container.getVolumeM3(),
                container.getContainerId()
        );
    }
}
