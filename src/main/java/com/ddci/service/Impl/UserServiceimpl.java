package com.ddci.service.Impl;

import com.ddci.exception.AppException;
import com.ddci.model.common.ErrorCode;
import com.ddci.model.common.SystemResponse;
import com.ddci.model.entity.User;
import com.ddci.model.request.UserLoginRequest;
import com.ddci.model.request.UserRequest;
import com.ddci.model.response.Response;
import com.ddci.model.response.UserResponse;
import com.ddci.repository.UserRepository;
import com.ddci.config.JwtProvider;
import com.ddci.service.UserService;
import com.ddci.service.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public UserServiceimpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public ResponseEntity<SystemResponse<UserResponse>> create(UserRequest request) {
        User user = mapper.map(request);
        repository.save(user);

        return Response.ok(mapper.map(user));
    }

    /**
     *  use to login
     * @param userLoginRequest
     * @return Jwt string
     */
    @Override
    public String login(UserLoginRequest userLoginRequest) {

        User user = repository.findUserByAccount(userLoginRequest.getAccount()).orElseThrow(()
                -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        if(!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())){
            throw new AppException(ErrorCode.WRONG_PASSWORD);
        }

        return jwtProvider.generateToken(user.getAccount(), user.getId());
    }
}
