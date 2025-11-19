package com.tpibackend.ruta_service.infrastructure.controller;

import com.tpibackend.ruta_service.application.dto.SegmentoRequestDTO;
import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.domain.model.Segmento;

public class SegmentoMapper {

    public static Segmento toEntity(SegmentoRequestDTO req, Ruta ruta) {
        Segmento s = new Segmento();

        s.setRuta(ruta);

        s.setOriginType(req.getOriginType());
        s.setOriginLat(req.getOriginLat());
        s.setOriginLng(req.getOriginLng());

        s.setDestLat(req.getDestLat());
        s.setDestLng(req.getDestLng());

        s.setSegmentType(req.getSegmentType());
        s.setStatus("PENDIENTE"); // por defecto

        s.setEstimatedDistanceKm(req.getEstimatedDistanceKm());
        s.setEstimatedTimeMin(req.getEstimatedTimeMin());
        s.setEstimatedCost(req.getEstimatedCost());

        s.setTruckId(req.getTruckId());

        return s;
    }
}