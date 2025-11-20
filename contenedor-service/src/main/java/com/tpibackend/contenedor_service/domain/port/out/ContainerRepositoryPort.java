package com.tpibackend.contenedor_service.domain.port.out;

import com.tpibackend.contenedor_service.domain.Container;

import java.util.List;
import java.util.Optional;

public interface ContainerRepositoryPort {
    Container save(Container client);
    List<Container> findAll();

    Optional<Container> findById(Long id);
}
