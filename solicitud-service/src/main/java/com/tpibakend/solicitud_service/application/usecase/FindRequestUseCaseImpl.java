package com.tpibakend.solicitud_service.application.usecase;

import com.tpibakend.solicitud_service.application.Mapper;
import com.tpibakend.solicitud_service.application.exception.SolicitudException;
import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.port.in.FindRequestUseCase;
import com.tpibakend.solicitud_service.domain.port.out.RequestRepositoryPort;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindRequestUseCaseImpl implements FindRequestUseCase {

    RequestRepositoryPort repositoryPort;

    @Override
    public Request findById(Long id) {
        return repositoryPort.findById(id).orElseThrow(() -> new SolicitudException("Request not found"));
    }

    @Override
    public List<Request> findAll() {
        return repositoryPort.findAll();
    }
}
