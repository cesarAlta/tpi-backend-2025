package com.tpibackend.contenedor_service.domain.port.in;

import com.tpibackend.contenedor_service.domain.Container;

import java.util.List;
import java.util.Optional;

public interface FindContainerUseCase {
    List<Container> findAll();
    Container findById(Long id);
}
