package com.tamerb.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public RegisterDto() {
    }

}
