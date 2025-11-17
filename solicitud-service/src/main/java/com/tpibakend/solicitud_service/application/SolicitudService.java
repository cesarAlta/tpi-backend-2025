package com.tpibakend.solicitud_service.application;

import com.tpibakend.solicitud_service.infrastructure.controller.dto.SolicitudRequestDTO;
import com.tpibakend.solicitud_service.domain.Solicitud;

public interface SolicitudService {

    Solicitud crearSolicitud(SolicitudRequestDTO dto);

    Solicitud obtenerSolicitud(Long id);

    Solicitud actualizarEstado(Long id, String nuevoEstado);
}
