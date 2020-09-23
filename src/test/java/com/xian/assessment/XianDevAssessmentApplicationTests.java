package com.xian.assessment;

import com.xian.assessment.controller.CartonController;
import com.xian.assessment.model.dto.CalculateRequest;
import com.xian.assessment.model.dto.CartonDTO;
import com.xian.assessment.model.dto.CommonResponse;
import com.xian.assessment.repository.CartonRepository;
import com.xian.assessment.service.CartonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class XianDevAssessmentApplicationTests {

    @Autowired
    private CartonRepository cartonRepository;

    @Autowired
    private CartonService cartonService;

    @Test
    void contextLoads() {
        System.out.println(cartonService.getCalculatedPrice(new CalculateRequest(1, 3, 4)));
    }

}
