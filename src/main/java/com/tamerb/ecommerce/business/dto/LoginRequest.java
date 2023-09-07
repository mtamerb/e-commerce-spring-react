package com.tamerb.ecommerce.business.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @Schema(example = "username")
    @NotBlank
    private String username;

    @Schema(example = "password")
    @NotBlank
    private String password;
}