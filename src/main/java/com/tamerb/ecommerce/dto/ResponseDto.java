package com.tamerb.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter

public class ResponseDto {

    private String message;

    private HttpStatus status;

    public ResponseDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status;

    }
}
