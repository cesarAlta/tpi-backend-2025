package com.tpibakend.contenedor_service.application;

import com.tpibakend.contenedor_service.application.exception.ContainerException;
import com.tpibakend.contenedor_service.domain.Container;
import com.tpibakend.contenedor_service.infraestructure.controller.dto.ContainerRequest;
import com.tpibakend.contenedor_service.infraestructure.persistence.SpringDataContainer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ContainerService {
    SpringDataContainer springDataContainer;
    public Container createContainer(ContainerRequest containerRequest) {
        Container container = Container.createNew(
                containerRequest.weightKg(),containerRequest.volumeM3(),containerRequest.clientId()
        );
        return springDataContainer.save(container);
    }

    public Container getContainer(Long id) {
        return getContainerById(id);
    }

    private Container getContainerById(Long id) {
        return springDataContainer.findById(id).orElseThrow(()-> new ContainerException("CONTAINER_NOT_FOUND"));
    }
}
