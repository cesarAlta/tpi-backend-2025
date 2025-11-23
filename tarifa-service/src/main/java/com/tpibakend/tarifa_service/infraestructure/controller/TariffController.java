package com.tpibakend.tarifa_service.infraestructure.controller;

import com.tpibakend.tarifa_service.application.TariffService;
import com.tpibakend.tarifa_service.infraestructure.controller.dto.TariffResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tarifas")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class TariffController {

    TariffService tariffService;

    @GetMapping("/vigente")
    public ResponseEntity<?> getTariff(){
      TariffResponse res = tariffService.getCurrentTariff();
      return ResponseEntity.ok(res);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
      List<TariffResponse> res = tariffService.getAll();
      return ResponseEntity.ok(res);
    }


}
