package com.tpibakend.solicitud_service.application;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;

public class Mapper {
    public static RequestResponse toRequestResponse(Request request) {
        return request == null
                ? null
                : new RequestResponse(
                request.getRequestId(),
                request.getRequestNumber(),
                request.getClientId(),
                request.getClientId(),
                request.getHistories(),
                request.getEstimatedCost(),
                request.getEstimatedTimeMin(),
                request.getEstimatedCost(),
                request.getActualTimeMin(),
                request.getCreatedAt());
    }
}
