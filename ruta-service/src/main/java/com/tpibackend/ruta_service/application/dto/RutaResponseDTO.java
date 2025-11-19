package com.tpibackend.ruta_service.application.dto;

import com.tpibackend.ruta_service.domain.model.Ruta;
import lombok.Data;

@Data
public class RutaResponseDTO {
    private Long rutaId;
    private Long requestId;

    public static RutaResponseDTO from(Ruta r){
        RutaResponseDTO dto = new RutaResponseDTO();
        dto.setRutaId(r.getRutaId());
        dto.setRequestId(r.getRequestId());
        return dto;
    }
}