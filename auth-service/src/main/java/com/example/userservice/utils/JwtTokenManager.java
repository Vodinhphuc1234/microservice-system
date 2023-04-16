package com.example.userservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by vodinhphuc on 29/03/2023
 */
@Component
@RequiredArgsConstructor
public class JwtTokenManager {
    public String generateAccessToken(User user) {
        final String username = user.getUsername();
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .sign(Algorithm.HMAC256("secret"));
    }
    public String generateRefreshToken(User user) {
        final String username = user.getUsername();
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30*60 * 60 * 1000))
                .sign(Algorithm.HMAC256("secret"));
    }

    public String getUsernameFromToken(String token) {

        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getSubject();
    }

    public boolean validateToken(String token) {
        final String usernameFromToken = getUsernameFromToken(token);
        final boolean tokenExpired = isTokenExpired(token);
        return usernameFromToken != null && !tokenExpired;
    }

    private boolean isTokenExpired(String token) {

        final Date expirationDateFromToken = getExpirationDateFromToken(token);
        return expirationDateFromToken.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {

        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getExpiresAt();
    }

    private DecodedJWT getDecodedJWT(String token) {

        final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("secret")).build();

        return jwtVerifier.verify(token);
    }

}
