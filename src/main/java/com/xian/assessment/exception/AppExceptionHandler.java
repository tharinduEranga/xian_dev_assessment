package com.xian.assessment.exception;

import com.xian.assessment.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(value = {CustomServiceException.class})
    public ResponseEntity<ErrorResponse> handleInvalidInputException(CustomServiceException ex) {
        log.error("Business Exception: " + ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponse> handleInvalidInputException(Exception ex) {
        log.error("Server Exception: " + ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Something went wrong! ".concat(ex.getMessage())));
    }

}
