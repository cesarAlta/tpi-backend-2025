package com.tpibakend.solicitud_service.application.usecase;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.port.in.CreateRequestUseCase;
import com.tpibakend.solicitud_service.domain.port.out.ClientWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.ContainerWebClientPort;
import com.tpibakend.solicitud_service.domain.port.out.RouteServicePort;
import com.tpibakend.solicitud_service.domain.port.out.TariffServicePort;
import com.tpibakend.solicitud_service.infraestructure.adapter.KmTiempoEstimadoConsumoProm;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.*;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.persistence.SpringDataRequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateRequestUseCaseImpl implements CreateRequestUseCase {

    ClientWebClientPort clientWebClientPort;
    ContainerWebClientPort containerWebClientPort;
    RouteServicePort routeServicePort;
    TariffServicePort tariffServicePort;
    SpringDataRequestRepository requestRepository;

    @Override
    public Request execute(RequestCreateRequest requestCreateRequest, Jwt jwt) {
        String keycloakId = jwt.getSubject();

        Long clientId = clientWebClientPort.getClientIdByKeycloakId(keycloakId)
                .orElseGet(() -> clientWebClientPort.createClient(
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

        KmTiempoEstimadoConsumoProm kmTiempoEstimadoConsumoProm = routeServicePort
                .getDistanciaDirecta(
                        new OriginDestination(
                                requestCreateRequest.originLat(),
                                requestCreateRequest.originLng(),
                                requestCreateRequest.destinationLat(),
                                requestCreateRequest.destinationLng()
                        )
                );

        EstimatedTariffResponse estimatedCost = tariffServicePort.getEstimatedRate(
                new EstimatedTariffRequest(
                        requestCreateRequest.containerWeight(),
                        requestCreateRequest.containerVolume(),
                        kmTiempoEstimadoConsumoProm.distanceKm(),
                        kmTiempoEstimadoConsumoProm.timeMinutes(),
                        kmTiempoEstimadoConsumoProm.consumoPromedio()
                ));

        String requestNumber = codeRequest(requestRepository.count() + 1);

        Request request = Request.createDraftRequest(clientId, containerId, requestNumber,
                requestCreateRequest.originLat(),
                requestCreateRequest.originLng(),
                requestCreateRequest.originAddress(),
                requestCreateRequest.destinationLat(),
                requestCreateRequest.destinationLng(),
                requestCreateRequest.destinationAddress(),
                estimatedCost.estimatedCost(),
                kmTiempoEstimadoConsumoProm.timeMinutes()
        );

        return requestRepository.save(request);
    }

    private String codeRequest(Long num) {
        return String.format("%05d", num);
    }
}
