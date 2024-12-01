package com.codingshuttle.production_ready_feature.prod.advices;

import com.codingshuttle.production_ready_feature.prod.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError>HandleResourceNOtFoundException(ResourceNotFoundException exception){
       // ApiError apiError=ApiError.builder().errorMessage(exception.getLocalizedMessage()).statusCode(HttpStatus.NOT_FOUND).build();
        ApiError apiError=new ApiError(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }


}
