package com.tamerb.ecommerce.config;

import java.time.LocalDateTime;

public record ApiResponse(boolean success, String message) {


    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }


}
