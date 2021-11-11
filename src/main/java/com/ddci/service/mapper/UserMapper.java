package com.ddci.service.mapper;

import com.ddci.model.entity.User;
import com.ddci.model.request.UserRequest;
import com.ddci.model.response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User map(UserRequest request){
        User user = new User();

        user.setName(request.getName());
        user.setAccount(request.getAccount());
        user.setUserType(request.getUserType());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return user;
    }

    public UserResponse map(User user){
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setUserType(user.getUserType());
        userResponse.setName(user.getName());
        userResponse.setAccount(user.getAccount());

        return userResponse;
    }
}
