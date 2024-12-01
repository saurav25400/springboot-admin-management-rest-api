package com.codingshuttle.production_ready_feature.prod.advices;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ApiError {
    private LocalDateTime timestamp;
    private String errorMessage;
    private HttpStatus statusCode;

    public ApiError(){
        this.timestamp=LocalDateTime.now();
    }

    public ApiError(String errorMessage, HttpStatus statusCode) {
        this();
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
