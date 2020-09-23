package com.xian.assessment.service;

import com.xian.assessment.model.dto.CalculateRequest;
import com.xian.assessment.model.dto.CartonDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface CartonService {

    List<CartonDTO> getCartonPrices();

    BigDecimal getCalculatedPrice(CalculateRequest calculateRequest);
}
