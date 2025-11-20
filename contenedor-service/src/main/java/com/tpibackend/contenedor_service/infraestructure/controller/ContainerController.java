package com.tpibackend.contenedor_service.infraestructure.controller;

import com.tpibackend.contenedor_service.application.ContainerService;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerRequest;
import com.tpibackend.contenedor_service.infraestructure.controller.dto.ContainerResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenedores")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ContainerController {
    ContainerService containerService;

    @PostMapping
    ResponseEntity<?> createContainer(@Valid @RequestBody ContainerRequest request) {
        val container = containerService.createContainer(request);
        return ResponseEntity.ok(container);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getContainer(@PathVariable Long id) {
        val containerResponse = containerService.getContainer(id);
        return ResponseEntity.ok(containerResponse);
    }
    @GetMapping
    ResponseEntity<?> getAll() {
        List<ContainerResponse> containerResponse = containerService.getAll();
        return ResponseEntity.ok(containerResponse);
    }

}
