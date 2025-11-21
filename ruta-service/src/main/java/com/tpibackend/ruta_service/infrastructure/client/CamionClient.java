package com.tpibackend.ruta_service.infrastructure.client;


import com.tpibackend.ruta_service.infrastructure.client.dto.CamionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "camion-service", url = "http://camion-service:8084")
public interface CamionClient {

    @GetMapping("/camiones/disponibles")
    CamionDTO getCamionDisponible();

    @PutMapping("/camiones/{id}/asignar")
    void marcarComoOcupado(@PathVariable Long id);
}