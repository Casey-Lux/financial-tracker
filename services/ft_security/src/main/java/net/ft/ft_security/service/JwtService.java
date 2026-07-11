package net.ft.ft_security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.security.KeyPair;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final KeyPair keyPair;

    @Value("${spring.application.security.jwt.expiration}")
    private long jwtExpirationInMs;

    public String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + jwtExpirationInMs))
                .signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256)
                .compact();
    }
}
