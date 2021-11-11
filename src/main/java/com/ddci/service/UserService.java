package com.ddci.service;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.UserLoginRequest;
import com.ddci.model.request.UserRequest;
import com.ddci.model.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<SystemResponse<UserResponse>> create(UserRequest request);

    String login(UserLoginRequest userLoginRequest);
}
