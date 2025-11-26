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
    public RouteLocator configurarRutas(RouteLocatorBuilder builder,
                                        @Value("${clientes-service.url}") String uriClienteService,
                                        @Value("${solicitud-service.url}") String uriSolicitudService,
                                        @Value("${contenedor-service.url}") String uriContenedorService,
                                        @Value("${tarifa-service.url}") String uriTarifaService,
                                        @Value("${ruta-service.url}") String uriRutaService
    ) {
        return builder.routes()
                // Ruteo al Microservicio de Entradas
                .route(p -> p.path("/api/clientes/**").uri(uriClienteService))
                .route(p -> p.path("/api/solicitudes/**").uri(uriSolicitudService))
                .route(p -> p.path("/api/contenedores/**").uri(uriContenedorService))
                .route(p -> p.path("/api/tarifas/**").uri(uriTarifaService))
                .route(p -> p.path("/api/rutas/**").uri(uriRutaService))
                .build();
    }
}
