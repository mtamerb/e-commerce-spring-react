package com.tamerb.ecommerce.auth.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
public class AuthResponse{

    private String token;
    private String message;
    private HttpStatus response;


    public AuthResponse(String token, String message, HttpStatus response) {
        this.token = token;
        this.message = message;
        this.response = response;
    }

    public AuthResponse(String message, HttpStatus response) {
        this.message = message;
        this.response = response;
    }
}
