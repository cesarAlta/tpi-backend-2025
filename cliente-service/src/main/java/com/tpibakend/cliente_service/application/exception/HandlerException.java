package com.tpibakend.cliente_service.application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(ClientException.class)
    ResponseEntity<?> handlerClientException( ClientException e){
        return ResponseEntity.badRequest().body(Map.of("message",e.getMessage()));
    }
}
