package com.tpibakend.deposito_service.application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(DepositoException.class)
    public ResponseEntity<?> handlerDepositoException(DepositoException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }
}
