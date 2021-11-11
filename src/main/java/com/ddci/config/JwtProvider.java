package com.ddci.config;

import com.ddci.exception.AppException;
import com.ddci.model.common.ErrorCode;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String SECRET_KEY;


    public String getAccountFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return getExpirationFromToken(token).before(new Date());
    }

    public String generateToken(String account, int employeeId) {

        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, account ,employeeId);
    }

    private String doGenerateToken(Map<String, Object> claims, String account, int employeeId) {

        Instant IssuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant expiration = IssuedAt.plus(5, ChronoUnit.MINUTES);

        return Jwts.builder().setClaims(claims).setSubject(account).setIssuedAt(Date.from(IssuedAt))
                .setExpiration(Date.from(expiration)).claim("employee-id", employeeId)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

//    public Boolean validateToken(String token, String account) {
//        final String username = getAccountFromToken(token);
//        return (username.equals(account) && !isTokenExpired(token));
//    }

    public Boolean CheckToken(String token) {
        try {

            String account = getAllClaimsFromToken(token).getSubject();

            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
            throw new AppException(ErrorCode.FAIL_AUTHORIZATION);
        }

    }


}