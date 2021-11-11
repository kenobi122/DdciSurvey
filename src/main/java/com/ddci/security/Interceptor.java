package com.ddci.security;

import com.ddci.config.JwtProvider;
import com.ddci.exception.AppException;
import com.ddci.model.common.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@Component
public class Interceptor implements HandlerInterceptor {
    private static final String[] AllowApi = {"^/user/login$","^/login$", "^/login?error", "^/error",
            "^/employee$","^/employee/login$","^/employee/create$","^/employee/get-all", "^/configuration/ui$", "^/swagger-resources$","^/swagger-resources/\\**$",
            "^/swagger-ui.html$", "^/webjars/\\**$","^/swagger-resources/configuration/ui$","^/swagger-ui.html$"};

    private final JwtProvider jwtProvider;

    public Interceptor(JwtProvider jwtProvider){
        this.jwtProvider = jwtProvider;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String authorizationHeader = request.getHeader("Authorization");

        /** allow some api without jwt check **/
        if (AllowApiInterceptor(request)) return true;

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

            throw new AppException(ErrorCode.JWT_NOT_FOUND);

        }

        if (authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            return jwtProvider.CheckToken(token);
        }

        return true;
    }

    private boolean AllowApiInterceptor(HttpServletRequest request) {

        for (String allowApi : AllowApi) {

            Pattern pattern = Pattern.compile(allowApi);
            String url = request.getRequestURI();

            boolean matches = pattern
                    .matcher(url)
                    .matches();

            if (matches) {
                return true;
            }
        }

        return false;
    }

}
