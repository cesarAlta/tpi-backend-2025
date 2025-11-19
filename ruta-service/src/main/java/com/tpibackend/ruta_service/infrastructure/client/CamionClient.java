package com.tpibackend.ruta_service.infrastructure.client;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "camion-service", url = "${ms.camion.url}")
public interface CamionClient {

    @GetMapping("/camiones/disponibles")
    CamionDTO getCamionDisponible();

    @PutMapping("/camiones/{id}/asignar")
    void marcarComoOcupado(@PathVariable Long id);
}