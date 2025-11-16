package com.tpibakend.deposito_service.infrastructure.controller;

import com.tpibakend.deposito_service.application.DepositoService;
import com.tpibakend.deposito_service.infrastructure.controller.dto.DepositoRequest;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/depositos")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DepositoController {

    DepositoService depositoService;

    @PostMapping
    public ResponseEntity<?> crearDeposito(@RequestBody DepositoRequest request) {
        return ResponseEntity.ok(depositoService.registrarDeposito(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeposito(@PathVariable Long id) {
        return ResponseEntity.ok(depositoService.obtenerDeposito(id));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(depositoService.listarDepositos());
    }
}
