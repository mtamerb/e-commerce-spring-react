package com.tamerb.ecommerce.auth.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {

    @Schema(example = "username")
    @NotBlank
    private String username;

    @Schema(example = "password")
    @NotBlank
    private String password;

    @Schema(example = "first name")
    @NotBlank
    private String firstName;

    @Schema(example = "last name")
    @NotBlank
    private String lastName;

    @Schema(example = "user@mycompany.com")
    @Email
    private String email;
}