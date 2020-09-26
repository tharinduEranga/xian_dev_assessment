package com.xian.assessment.controller;

import com.xian.assessment.model.dto.CalculateRequest;
import com.xian.assessment.model.dto.CartonDTO;
import com.xian.assessment.model.dto.CartonNameDTO;
import com.xian.assessment.model.dto.CommonResponse;
import com.xian.assessment.service.CartonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/carton")
@RequiredArgsConstructor
@Slf4j
public class CartonController {

    private final CartonService cartonService;

    @GetMapping()
    public ResponseEntity<CommonResponse<List<CartonDTO>>> getCartons() {
        log.info("End point:- Get cartons");
        return ResponseEntity.ok(new CommonResponse<>(cartonService.getCartonPrices()));
    }

    @GetMapping(value = "/names")
    public ResponseEntity<CommonResponse<List<CartonNameDTO>>> getCartonNames() {
        log.info("End point:- Get carton names");
        return ResponseEntity.ok(new CommonResponse<>(cartonService.getCartonNames()));
    }

    @GetMapping(value = "/{cartonId}")
    public ResponseEntity<CommonResponse<CartonDTO>> getCartonById(@PathVariable("cartonId") long cartonId) {
        log.info("End point:- Get carton by id\t ID: {}", cartonId);
        return ResponseEntity.ok(new CommonResponse<>(cartonService.getCartonById(cartonId)));
    }

    @PostMapping(value = "/calculate")
    public ResponseEntity<CommonResponse<BigDecimal>> getCartonCalculateAmount(@RequestBody CalculateRequest calculateRequest) {
        log.info("End point:- Calculate carton amounts\tRequest: {}", calculateRequest);
        return ResponseEntity.ok(new CommonResponse<>(cartonService.getCalculatedPrice(calculateRequest)));
    }
}
