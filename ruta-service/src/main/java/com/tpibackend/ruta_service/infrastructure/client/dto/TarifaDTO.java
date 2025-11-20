package com.tpibackend.ruta_service.infrastructure.client.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TarifaDTO {
    private BigDecimal precioBase;
}