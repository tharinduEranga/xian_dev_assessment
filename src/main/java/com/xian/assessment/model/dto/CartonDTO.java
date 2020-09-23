package com.xian.assessment.model.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CartonDTO {

    private long id;
    private String name;
    private int units;
    private BigDecimal price;

}
