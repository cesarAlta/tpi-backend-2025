package com.tpibakend.solicitud_service.infraestructure.controller;

import com.tpibakend.solicitud_service.application.service.RequestService;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestCreateRequest;
import com.tpibakend.solicitud_service.infraestructure.controller.dto.RequestResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/requests")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestController {
    RequestService requestService;

    @PostMapping
    ResponseEntity<?> createRequest(@RequestBody RequestCreateRequest requestCreateRequest) {
        RequestResponse resp = requestService.createRequest(requestCreateRequest);
        return ResponseEntity.ok().build();
    }
}
