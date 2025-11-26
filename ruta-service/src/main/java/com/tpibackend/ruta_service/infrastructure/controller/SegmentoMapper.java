package com.tpibackend.ruta_service.infrastructure.controller;

import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.domain.model.SegmentType;
import com.tpibackend.ruta_service.domain.model.Segmento;
import com.tpibackend.ruta_service.domain.model.Status;
import com.tpibackend.ruta_service.infrastructure.controller.dto.SegmentoRequest;
import com.tpibackend.ruta_service.infrastructure.controller.dto.SegmentoResponse;

/*public class SegmentoMapper {

    public static Segmento toEntity(SegmentoRequest req, Ruta ruta) {
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
}*/



public class SegmentoMapper {

    public static Segmento toEntity(SegmentoRequest req, Ruta ruta) {
        Segmento s = new Segmento();
        s.setRuta(ruta);
        s.setOriginType(req.getOriginType());
        s.setOriginLat(req.getOriginLat());
        s.setOriginLng(req.getOriginLng());
        s.setDestLat(req.getDestLat());
        s.setDestLng(req.getDestLng());
        s.setSegmentType(SegmentType.valueOf(req.getSegmentType()));
        s.setEstimatedDistanceKm(req.getEstimatedDistanceKm());
        s.setStatus(Status.ASIGNADO); // o lo que uses por defecto

        return s;
    }

    public static SegmentoResponse toResponse(Segmento s) {
        SegmentoResponse r = new SegmentoResponse();

        r.setId(s.getSegmentoId());  // O el nombre real del campo ID de Segmento
        r.setRutaId(s.getRuta().getRutaId());

        r.setOriginType(s.getOriginType());
        r.setOriginLat(s.getOriginLat());
        r.setOriginLng(s.getOriginLng());

        r.setDestLat(s.getDestLat());
        r.setDestLng(s.getDestLng());

        r.setSegmentType(s.getSegmentType().toString());
        r.setEstimatedDistanceKm(s.getEstimatedDistanceKm());
        r.setStatus(s.getStatus().toString());

        return r;
    }

}






