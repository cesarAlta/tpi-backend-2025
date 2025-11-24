package com.tpibakend.solicitud_service.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Value("${cliente-service.url}")
    String clienteService;
    @Value("${contenedor-service.url}")
    String contenedorService;
    @Value("${tarifa-service.url}")
    String tarifaService;
    @Value("${ruta-service.url}")
    String rutaService;



    @Bean
    public RestClient clientServiceClient() {
        return RestClient.builder()
                .baseUrl(clienteService)
                .requestInterceptor(requestInterceptor())
                .build();
    }

    @Bean
    public RestClient containerServiceClient() {
        return RestClient.builder()
                .baseUrl(contenedorService)
                .requestInterceptor(requestInterceptor())
                .build();
    }

    @Bean
    public RestClient routeServiceClient() {
        return RestClient.builder()
                .baseUrl(rutaService)
                .requestInterceptor(requestInterceptor())
                .build();
    }
    @Bean
    public RestClient tariffServiceClient() {
        return RestClient.builder()
                .baseUrl(tarifaService)
                .requestInterceptor(requestInterceptor())
                .build();
    }

    private ClientHttpRequestInterceptor requestInterceptor() {
        return (request, body, execution) -> {

            // Intenta obtener la información de autenticación del hilo actual
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // Si la autenticación es un token JWT válido (asumiendo tu setup de seguridad)
            if (authentication instanceof JwtAuthenticationToken) {
                // Extrae el token JWT original
                String tokenValue = ((JwtAuthenticationToken) authentication).getToken().getTokenValue();

                // Añade el header de Authorization a la petición saliente
                request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenValue);
            }

            // Continúa con la ejecución normal de la petición HTTP
            return execution.execute(request, body);
        };
    }
}
