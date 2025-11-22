package com.tpibakend.solicitud_service.infraestructure.controller.dto;

import java.time.LocalDateTime;

public record StatusResponse(
        String name,
        LocalDateTime createdAt
) {

}
