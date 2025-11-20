package com.tpibakend.solicitud_service.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient clientServiceClient() {
        return RestClient.builder()
                .baseUrl("http://cliente-service/api/clients")
                .build();
    }

    @Bean
    public RestClient containerServiceClient() {
        return RestClient.builder()
                .baseUrl("http://contenedor-service/api/containers")
                .build();
    }

    @Bean
    public RestClient routeServiceClient() {
        return RestClient.builder()
                .baseUrl("http://camion-service/api/route")
                .build();
    }
}
