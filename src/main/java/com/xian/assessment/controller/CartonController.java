package com.xian.assessment.controller;

import com.xian.assessment.model.dto.CartonDTO;
import com.xian.assessment.model.dto.CommonResponse;
import com.xian.assessment.service.CartonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carton")
@RequiredArgsConstructor
@Slf4j
public class CartonController {

    private final CartonService cartonService;

    @GetMapping()
    public ResponseEntity<CommonResponse<List<CartonDTO>>> getCartons() {
        return ResponseEntity.ok(new CommonResponse<>(cartonService.getCartonPrices()));
    }
}
