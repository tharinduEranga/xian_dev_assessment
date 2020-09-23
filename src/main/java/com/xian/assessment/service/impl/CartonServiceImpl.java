package com.xian.assessment.service.impl;

import com.xian.assessment.model.dto.CartonDTO;
import com.xian.assessment.model.entity.Carton;
import com.xian.assessment.repository.CartonRepository;
import com.xian.assessment.service.CartonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Carton business logic is applied here
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CartonServiceImpl implements CartonService {

    /*repos*/
    private final CartonRepository cartonRepository;

    /*util*/
    private final ModelMapper modelMapper;


    /**
     * This method can use to get cartons list from the database.
     *
     * @return the cartons DTO list.
     */
    @Override
    public List<CartonDTO> getCartonPrices() {
        List<Carton> cartonList = cartonRepository.findAll();
        return Arrays.asList(modelMapper.map(cartonList, CartonDTO[].class));
    }

}
