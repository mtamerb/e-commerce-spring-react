package com.tamerb.ecommerce.common;

import java.time.LocalDateTime;

public class ApiResponse {

    private final String message;
    private final boolean success;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
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
