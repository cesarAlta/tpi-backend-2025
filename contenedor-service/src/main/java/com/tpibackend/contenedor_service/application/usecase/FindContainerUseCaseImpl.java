package com.tpibackend.contenedor_service.application.usecase;

import com.tpibackend.contenedor_service.application.exception.ContainerException;
import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.domain.port.in.FindContainerUseCase;
import com.tpibackend.contenedor_service.domain.port.out.ContainerRepositoryPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindContainerUseCaseImpl implements FindContainerUseCase {
    ContainerRepositoryPort repositoryPort;

    @Override
    public List<Container> findAll() {
        return repositoryPort.findAll();
    }

    @Override
    public Container findById(Long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new ContainerException("Container not found"));
    }
}
