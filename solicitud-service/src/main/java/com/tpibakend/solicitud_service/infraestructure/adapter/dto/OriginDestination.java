package com.tpibakend.solicitud_service.infraestructure.adapter.dto;

public record OriginDestination(
        Double originLat,
        Double originLng,
        Double destinationLat,
        Double destinationLng
) {
}
