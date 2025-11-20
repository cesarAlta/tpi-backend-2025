package com.tpibackend.contenedor_service.application.usecase;

import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.domain.port.in.CreateContainerUseCase;
import com.tpibackend.contenedor_service.domain.port.out.ContainerRepositoryPort;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateContainerUseCaseImpl implements CreateContainerUseCase {

    ContainerRepositoryPort repositoryPort;

    @Override
    public Container execute(ContainerRequest containerRequest) {
        Container container = Container.createNew(
                containerRequest.weightKg(), containerRequest.volumeM3(), containerRequest.clientId());

        return repositoryPort.save(container);
    }
}
