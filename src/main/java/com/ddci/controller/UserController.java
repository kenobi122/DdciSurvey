package com.ddci.controller;

import com.ddci.model.common.SystemResponse;
import com.ddci.model.request.UserLoginRequest;
import com.ddci.model.request.UserRequest;
import com.ddci.model.response.Response;
import com.ddci.model.response.UserResponse;
import com.ddci.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<UserResponse>> create(@RequestBody UserRequest request){
        return userService.create(request);
    }

    @PostMapping("/login")
    public ResponseEntity<SystemResponse<String>> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return Response.ok(userService.login(userLoginRequest));

    }

}
