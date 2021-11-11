package com.ddci.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginRequest {
    @NotBlank
    private String account;
    @NotBlank
    private String password;
}
