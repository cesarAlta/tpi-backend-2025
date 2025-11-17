package com.tpibakend.contenedor_service.infraestructure.controller;

import com.tpibakend.contenedor_service.application.ContainerService;
import com.tpibakend.contenedor_service.infraestructure.controller.dto.ContainerRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/containers")
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
        val container = containerService.getContainer(id);
        return ResponseEntity.ok(container);
    }

}
