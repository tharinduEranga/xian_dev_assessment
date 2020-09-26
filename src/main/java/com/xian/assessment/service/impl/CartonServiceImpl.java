package com.xian.assessment.service.impl;

import com.xian.assessment.exception.CustomServiceException;
import com.xian.assessment.model.dto.CalculateRequest;
import com.xian.assessment.model.dto.CartonDTO;
import com.xian.assessment.model.dto.CartonNameDTO;
import com.xian.assessment.model.entity.Carton;
import com.xian.assessment.model.entity.PriceStructure;
import com.xian.assessment.repository.CartonRepository;
import com.xian.assessment.repository.PriceStructureRepository;
import com.xian.assessment.service.CartonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static com.xian.assessment.util.AppConstants.NotFound.NO_CARTON_FOUND;
import static com.xian.assessment.util.AppConstants.NotFound.NO_PRICE_STRUCTURE;

/**
 * Carton business logic is applied here
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CartonServiceImpl implements CartonService {

    /*repos*/
    private final CartonRepository cartonRepository;
    private final PriceStructureRepository priceStructureRepository;

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

    /**
     * This method can use to get cartons name list from the database.
     *
     * @return the cartons names DTO list.
     */
    @Override
    public List<CartonNameDTO> getCartonNames() {
        return cartonRepository.getCartonNames();
    }

    /**
     * This method can use to get a carton by given id from the database.
     *
     * @return the carton of the ID
     */
    @Override
    public CartonDTO getCartonById(long cartonId) {
        return modelMapper.map(cartonRepository.findById(cartonId)
                .orElseThrow(() -> new CustomServiceException(404, NO_CARTON_FOUND)), CartonDTO.class);
    }

    /**
     * Gets the calculated price for the given ordered products.
     *
     * @param calculateRequest the calculation request data
     * @return the calculated amount according to the business rules.
     */
    @Override
    public BigDecimal getCalculatedPrice(CalculateRequest calculateRequest) {

        /*get price structure amount*/
        PriceStructure priceStructure = getPriceStructure();
        /*get carton details if exist*/
        Carton carton = getCarton(calculateRequest.getCartonId());

        BigDecimal unitPriceSum = BigDecimal.ZERO;
        BigDecimal discountedAmount = BigDecimal.ZERO;

        /*checks for unit prices and set prices if more than one single units*/
        if (calculateRequest.getUnitCount() > 0)
            unitPriceSum = getUnitPriceSum(priceStructure, carton, calculateRequest.getUnitCount());

        /*checks carton count and set discount if more than the initial value*/
        if (calculateRequest.getCartonCount() >= priceStructure.getCountForCartonDiscount()) {
            discountedAmount = carton.getPrice().multiply(priceStructure.getCartonDiscount());
        }

        /*gets the final amount by subtracting discounts and adding the unit price sum*/
        BigDecimal cartonPriceSum = carton.getPrice().multiply(new BigDecimal(String.valueOf(calculateRequest.getCartonCount())));
        return cartonPriceSum.subtract(discountedAmount).add(unitPriceSum).setScale(2, RoundingMode.UP);

    }

    /**
     * Gets the unit price sum for the given carton and unit count.
     *
     * @param priceStructure the price structure data
     * @param carton         the carton details
     * @param unitCount      the coumt of units
     * @return the unit price sum of the given count
     */
    private BigDecimal getUnitPriceSum(PriceStructure priceStructure, Carton carton, long unitCount) {
        return getSingleUnitPrice(priceStructure, carton).multiply(new BigDecimal(String.valueOf(unitCount)));
    }

    /**
     * @return the price structure in the DB.
     * @throws CustomServiceException if mo prices in DB.
     */
    private PriceStructure getPriceStructure() {
        List<PriceStructure> priceStructures = priceStructureRepository.findAll();
        if (priceStructures.isEmpty())
            throw new CustomServiceException(HttpStatus.NO_CONTENT.value(), NO_PRICE_STRUCTURE);
        return priceStructures.get(0);
    }

    /**
     * @param cartonId the carton id to get.
     * @return the carton in the DB of the given id.
     * @throws CustomServiceException if the given carton does not exist.
     */
    private Carton getCarton(long cartonId) {
        return cartonRepository.findById(cartonId)
                .orElseThrow(() -> new CustomServiceException(HttpStatus.NOT_FOUND.value(), NO_CARTON_FOUND));
    }

    /**
     * @param priceStructure the price structure data
     * @param carton         the carton details
     * @return the single unit price of a carton
     */
    private BigDecimal getSingleUnitPrice(PriceStructure priceStructure, Carton carton) {
        return carton.getPrice().multiply(priceStructure.getSingleUnitPriceIncrease())
                .divide(BigDecimal.valueOf(carton.getUnits()), 2, RoundingMode.CEILING);
    }

}
