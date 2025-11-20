package com.tpibackend.contenedor_service.application;

import com.tpibackend.contenedor_service.application.exception.ContainerException;
import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.domain.port.in.CreateContainerUseCase;
import com.tpibackend.contenedor_service.domain.port.in.FindContainerUseCase;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerRequest;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerResponse;
import com.tpibackend.contenedor_service.infraestructure.persistence.SpringDataContainer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContainerService {
    CreateContainerUseCase createContainerUseCase;
    FindContainerUseCase findContainerUseCase;

    public Long createContainer(ContainerRequest containerRequest) {
        Container container = createContainerUseCase.execute(containerRequest);
        return container.getContainerId();
    }

    public ContainerResponse getContainer(Long id) {
        return Mapper.toContainerResponse(findContainerUseCase.findById(id));

    }

    public List<ContainerResponse> getAll() {
        return findContainerUseCase.findAll().stream()
                .map(Mapper::toContainerResponse)
                .toList();
    }
}
