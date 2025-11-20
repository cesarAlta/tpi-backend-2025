package com.tpibakend.solicitud_service.infraestructure.controller;

import com.tpibakend.solicitud_service.application.service.RequestService;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.metamodel.mapping.ordering.ast.RootSequencePart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/solicitudes")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestController {
    RequestService requestService;

    @PostMapping
    ResponseEntity<?> createRequest(@RequestBody RequestCreateRequest requestCreateRequest) {
        RequestResponse resp = requestService.createRequest(requestCreateRequest);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRequest(@PathVariable Long id) {
        RequestResponse requestResponse = requestService.findRequestById(id);
        return ResponseEntity.ok().body(requestResponse);
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        List<RequestResponse> res = requestService.getAll();
        return ResponseEntity.ok().body(res);
    }
}
