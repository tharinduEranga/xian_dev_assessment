package com.xian.assessment.exception;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomServiceException extends RuntimeException {

    private int code;
    private String message;

    public CustomServiceException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
