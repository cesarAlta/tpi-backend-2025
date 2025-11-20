package com.tpibakend.solicitud_service.application.service;

import com.tpibakend.solicitud_service.application.Mapper;
import com.tpibakend.solicitud_service.domain.port.in.CreateRequestUseCase;
import com.tpibakend.solicitud_service.domain.port.in.FindRequestUseCase;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestService {

    CreateRequestUseCase createRequestUseCase;
    FindRequestUseCase findRequestUseCase;

    public RequestResponse createRequest(RequestCreateRequest requestCreateRequest) {
        return Mapper.toRequestResponse(
                createRequestUseCase.execute(requestCreateRequest)
        );
    }
    public RequestResponse findRequestById(Long id) {
        return Mapper.toRequestResponse(findRequestUseCase.findById(id));
    }
    public List<RequestResponse> getAll() {
        return findRequestUseCase.findAll().stream()
                .map(Mapper::toRequestResponse)
                .toList();
    }
}
