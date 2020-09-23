package com.xian.assessment.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class CartonDTO {

    private long id;
    private String name;
    private int units;
    private BigDecimal price;

}
