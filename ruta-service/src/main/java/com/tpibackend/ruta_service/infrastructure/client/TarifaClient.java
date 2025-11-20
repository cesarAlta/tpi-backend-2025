package com.tpibackend.ruta_service.infrastructure.client;

import com.tpibackend.ruta_service.infrastructure.client.dto.TarifaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tarifa-service", url = "${ms.tarifa.url}")
public interface TarifaClient {

    @GetMapping("/tarifas/base")
    TarifaDTO getTarifaBase();
}