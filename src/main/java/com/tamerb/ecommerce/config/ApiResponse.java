package com.tamerb.ecommerce.config;

import java.time.LocalDateTime;

public class ApiResponse {

    private final String message;
    private final boolean success;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }


}
