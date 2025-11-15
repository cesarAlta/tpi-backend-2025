package com.tpibakend.tarifa_service.infraestructure.controller;

import com.tpibakend.tarifa_service.application.TariffService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class TariffController {

    TariffService tariffService;

}
