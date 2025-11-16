package com.example.solicitudservice.service;

import com.example.solicitudservice.dto.SolicitudRequestDTO;
import com.example.solicitudservice.model.Solicitud;

public interface SolicitudService {

    Solicitud crearSolicitud(SolicitudRequestDTO dto);

    Solicitud obtenerSolicitud(Long id);

    Solicitud actualizarEstado(Long id, String nuevoEstado);
}
