package com.tpibakend.solicitud_service.infraestructure.controller.dto;

import com.tpibakend.solicitud_service.domain.History;
import com.tpibakend.solicitud_service.domain.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record RequestResponse (
        Long requestId,
            String requestNumber,
            Long clientId,
            Long containerId,
            StatusResponse currentStatus,
            BigDecimal estimatedCost,
            Integer estimatedTimeMin,
            BigDecimal finalCost,
            Integer actualTimeMin,
            LocalDateTime createdAt
){
}
