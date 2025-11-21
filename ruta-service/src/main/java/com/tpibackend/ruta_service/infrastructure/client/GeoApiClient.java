package com.tpibackend.ruta_service.infrastructure.client;

//@FeignClient(name = "solicitud-service", url = "${ms.solicitud.url}")
//public interface SolicitudClient {

//    @GetMapping("/solicitudes/{id}")
//    SolicitudDTO getSolicitud(@PathVariable Long id);
//}

import com.tpibackend.ruta_service.infrastructure.client.dto.DistanciaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geoapi", url = "http://geoapi:8088")
public interface GeoApiClient {

    @GetMapping("/api/distancia")
    DistanciaDTO obtenerDistancia(
            @RequestParam("origen") String origen,
            @RequestParam("destino") String destino
    );
}