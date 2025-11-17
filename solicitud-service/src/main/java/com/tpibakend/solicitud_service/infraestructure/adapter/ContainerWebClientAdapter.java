package com.tpibakend.solicitud_service.infraestructure.adapter;

import com.tpibakend.solicitud_service.domain.port.out.ContainerWebClientPort;
import com.tpibakend.solicitud_service.infraestructure.adapter.dto.CreateContainerRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;


@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContainerWebClientAdapter implements ContainerWebClientPort {
    RestClient restClient;

    public ContainerWebClientAdapter(@Qualifier("containerServiceClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Long createContainer(CreateContainerRequest createContainerRequest) {
        return restClient.post()
                .body(createContainerRequest)
                .retrieve()
                .body(Long.class);
    }
}
