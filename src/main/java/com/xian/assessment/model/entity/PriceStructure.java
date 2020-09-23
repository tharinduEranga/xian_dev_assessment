package com.xian.assessment.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "price_structure")
public class PriceStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private BigDecimal singleUnitPriceIncrease;
    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private BigDecimal cartonDiscount;

    private int countForCartonDiscount;
}
