package com.tpibakend.tarifa_service.application.Exception;

import com.tpibakend.tarifa_service.domain.Tariff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(TariffException.class)
    public ResponseEntity<?> handleTariffException(TariffException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
