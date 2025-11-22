package com.tpibakend.solicitud_service.application;

import com.tpibakend.solicitud_service.domain.History;
import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.Status;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.StatusResponse;

public class Mapper {
    public static RequestResponse toRequestResponse(Request request) {
        return request == null
                ? null
                : new RequestResponse(
                request.getRequestId(),
                request.getRequestNumber(),
                request.getClientId(),
                request.getClientId(),
                getStatus(request.getCurrentHistoryState()),
                request.getEstimatedCost(),
                request.getEstimatedTimeMin(),
                request.getEstimatedCost(),
                request.getActualTimeMin(),
                request.getCreatedAt());
    }
    private static StatusResponse getStatus(History history){
       return new StatusResponse(history.getStatus().toString(), history.getChangeAt());
    }
}
