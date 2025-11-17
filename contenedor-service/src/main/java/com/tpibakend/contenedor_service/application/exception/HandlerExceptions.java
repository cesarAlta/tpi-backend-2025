package com.tpibakend.contenedor_service.application.exception;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationDTO(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ContainerException.class)
    public ResponseEntity<?> handlerContainerException(ContainerException ex) {
        HttpStatus status = switch (ex.getMessage()) {
            case "CONTAINER_NOT_FOUND" -> HttpStatus.NOT_FOUND;
            case "CONTAINER_ALREADY_EXISTS" -> HttpStatus.CONFLICT;
            case "INVALID_CONTAINER_DATA" -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
        return ResponseEntity.status(status).body(ex.getMessage());
    }
}
