package com.tamerb.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 401 - Client Error
@ResponseStatus(value=HttpStatus.CREATED)
public class ResourceCreatedException extends RuntimeException{

    public ResourceCreatedException(String message) {
        super(message);
    }
}