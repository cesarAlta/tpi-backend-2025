package com.tpibakend.solicitud_service.application.service;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.port.out.ClientWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.ContainerWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.RouteWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.ClientCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateContainerRequest;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateRouteRequest;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.RouteCreatedResponse;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import com.tpibakend.solicitud_service.infraestructure.persistence.SpringDataRequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestService {

    ClientWebClientPort clientWebClientPort;
    ContainerWebClientPort containerWebClientPort;
    RouteWebClientPort routeWebClientPort;
    SpringDataRequestRepository requestRepository;

    public RequestResponse createRequest(RequestCreateRequest requestCreateRequest) {
        Long clientId = clientWebClientPort.getByDocument(requestCreateRequest.clientDocument())
                .orElse(clientWebClientPort.createClient(
                        new ClientCreateRequest(
                                requestCreateRequest.clientName(),
                                requestCreateRequest.clientDocument(),
                                requestCreateRequest.clientEmail(),
                                requestCreateRequest.clientPhone()
                        )
                ));
        Long containerId = containerWebClientPort.createContainer(new CreateContainerRequest(
                requestCreateRequest.containerWeight(),
                requestCreateRequest.containerVolume(),
                clientId
        ));

        String requestNumber = String.valueOf(requestRepository.count());
        Request request = Request.createDraftRequest(clientId, containerId, requestNumber);

        return new RequestResponse();
    }
}
