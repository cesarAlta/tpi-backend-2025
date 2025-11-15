package com.tpibakend.cliente_service.application.exception;

public class ClientException extends RuntimeException{
    public ClientException( String message) {
        super(message);
    }
}
