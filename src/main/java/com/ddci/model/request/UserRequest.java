package com.ddci.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String account;

    @NotBlank
    private String password;

    @NotBlank
    private String userType;
}
