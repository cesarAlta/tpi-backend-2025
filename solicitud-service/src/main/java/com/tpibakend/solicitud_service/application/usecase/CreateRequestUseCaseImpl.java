package com.tpibakend.solicitud_service.application.usecase;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.port.in.CreateRequestUseCase;
import com.tpibakend.solicitud_service.domain.port.out.ClientWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.ContainerWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.RouteWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateContainerRequest;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.persistence.SpringDataRequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateRequestUseCaseImpl implements CreateRequestUseCase {

    ClientWebClientPort clientWebClientPort;
    ContainerWebClientPort containerWebClientPort;
    RouteWebClientPort routeWebClientPort;
    SpringDataRequestRepository requestRepository;

    @Override
    public Request execute(RequestCreateRequest requestCreateRequest, Jwt jwt) {
        String keycloakId = jwt.getSubject();

        Long clientId = clientWebClientPort.getClientIdByKeycloakId(keycloakId)
                .orElseGet(()-> clientWebClientPort.createClient(
                        new ClientCreateRequest(
                                requestCreateRequest.clientName(),
                                requestCreateRequest.clientDocument(),
                                requestCreateRequest.clientEmail(),
                                requestCreateRequest.clientPhone(),
                                keycloakId
                        )
                ));
        Long containerId = containerWebClientPort.createContainer(
                new CreateContainerRequest(
                        requestCreateRequest.containerWeight(),
                        requestCreateRequest.containerVolume(),
                        clientId
                ));

        String requestNumber = codeRequest(requestRepository.count() + 1);
        Request request = Request.createDraftRequest(clientId, containerId, requestNumber);

        return requestRepository.save(request);
    }
    private String codeRequest(Long num) {
        return String.format("%05d", num);
    }
}
