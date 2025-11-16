package com.tpibakend.solicitud_service.application.exception;

public class SolicitudException extends RuntimeException{
    public SolicitudException( String message) {
        super(message);
    }
}