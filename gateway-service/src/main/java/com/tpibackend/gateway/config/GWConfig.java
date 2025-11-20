package com.tpibackend.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@Configuration
@EnableWebFluxSecurity
public class GWConfig {
    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder, @Value("${clientes-service.url}") String uriClienteService
    ) {
        return builder.routes()
                // Ruteo al Microservicio de Entradas
                .route(p -> p.path("/api/clientes/**").uri(uriClienteService))
                .build();
    }
}
