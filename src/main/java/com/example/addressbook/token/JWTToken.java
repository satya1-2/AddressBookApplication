package com.example.addressbook.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class JWTToken {
    private static final String SECRET = "Satya";
    public static String createToken(int id) {
        String token;
        token = JWT.create()
                .withClaim("id", id)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static int decodeToken(String token) {
        int id = 0;
        if (token != null) {
            id = JWT.require(Algorithm.HMAC256(SECRET)).
                    build().verify(token).
                    getClaim("id").asInt();
        }
        return id;
    }
}
