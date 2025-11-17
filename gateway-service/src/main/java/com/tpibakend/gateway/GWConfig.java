package com.tpibakend.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GWConfig {
    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${apunte-api-gwkempes.url-microservicio-personas}") String uriPersonas,
                                        @Value("${apunte-api-gwkempes.url-microservicio-entradas}") String uriEntradas) {
        return builder.routes()
                // Ruteo al Microservicio de Personas
                .route(p -> p.path("/api/personas/**").uri(uriPersonas))
                // Ruteo al Microservicio de Entradas
                .route(p -> p.path("/api/entradas/**").uri(uriEntradas))
                .build();
    }
}
