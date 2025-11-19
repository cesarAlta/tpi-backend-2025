package com.tpibackend.ruta_service.infrastructure.client;

import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tarifa-service", url = "${ms.tarifa.url}")
public interface TarifaClient {

    @GetMapping("/tarifas/base")
    TarifaDTO getTarifaBase();
}