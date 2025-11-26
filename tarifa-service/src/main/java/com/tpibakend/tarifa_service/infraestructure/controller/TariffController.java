package com.tpibakend.tarifa_service.infraestructure.controller;

import com.tpibakend.tarifa_service.application.TariffService;
import com.tpibakend.tarifa_service.infraestructure.controller.dto.TariffResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/estimated-cost")
    public ResponseEntity<?> estimatedCost(
            @RequestParam Double averageDistance,
            @RequestParam Double contVol,
            @RequestParam Double contWeight,
            @RequestParam Double consumoProm
    ){
        BigDecimal res = tariffService.estimatedCost(averageDistance, contVol,
                contWeight, consumoProm);

      return ResponseEntity.ok(Map.of("estimatedCost", res));
    }



}
