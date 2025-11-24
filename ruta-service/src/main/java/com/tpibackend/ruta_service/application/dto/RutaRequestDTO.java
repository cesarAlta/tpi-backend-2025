package com.tpibackend.ruta_service.application.dto;

import lombok.Data;


public record RutaRequestDTO(
        Double origenLat,
        Double origenLng,
        Double destinoLat,
        Double ddestinoLng
){ }