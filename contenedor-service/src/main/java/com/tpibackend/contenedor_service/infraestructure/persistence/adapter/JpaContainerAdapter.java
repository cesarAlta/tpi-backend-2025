package com.tpibackend.contenedor_service.infraestructure.persistence.adapter;

import com.tpibackend.contenedor_service.domain.Container;
import com.tpibackend.contenedor_service.domain.port.out.ContainerRepositoryPort;
import com.tpibackend.contenedor_service.infraestructure.persistence.SpringDataContainer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class JpaContainerAdapter implements ContainerRepositoryPort {

    SpringDataContainer repository;
    @Override
    public Container save(Container container) {
        return repository.save(container);
    }

    @Override
    public List<Container> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Container> findById(Long id) {
        return repository.findById(id);
    }
}
