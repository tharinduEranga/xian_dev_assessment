package com.xian.assessment.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CalculateRequest {
    private long cartonId;
    private int cartonCount;
    private int unitCount;
}
