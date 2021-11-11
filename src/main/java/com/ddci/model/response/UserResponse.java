package com.ddci.model.response;

import lombok.Data;

@Data
public class UserResponse {
    private int id;

    private String name;

    private String account;

    private String userType;
}
