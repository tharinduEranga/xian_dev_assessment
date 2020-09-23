package com.xian.assessment.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommonResponse<T> {
    private T content;
}
