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
@Table(name = "carton")
public class Carton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int units;
    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private BigDecimal price;
}
