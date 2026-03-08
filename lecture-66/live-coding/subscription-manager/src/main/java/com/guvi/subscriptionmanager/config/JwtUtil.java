package com.guvi.subscriptionmanager.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import com.guvi.subscriptionmanager.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final long expirationMs;
    private final SecretKey secretKey;

    public JwtUtil(
            @Value("${app.jwt.expirationMinutes}") long expirationMs,
            @Value("${app.jwt.secret}") String secret) {
        this.expirationMs = expirationMs * 1000L;
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
        this.secretKey = Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(Long userId, Role role) {
        // sub (userId), claim (role), iat (current time),
        // signing w/ a key
        // expiry

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
            .subject(String.valueOf(userId))
            .claim("role", role.name())
            .issuedAt(now)
            .expiration(expiry)
            .signWith(secretKey)
            .compact();
    }

    // given a token -> is it valid? yes/no
    // Jwts -> parse, verify the token key -> get the Claims
    public boolean isTokenValid(String token) {
        // if verification or claim retrieval is erroring out,
        // then the token is invalid
        try {
            Claims claims = parseClaims(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }

    public Long extractUserId(String token) {
        Claims claims = parseClaims(token);
        // Gets user ID
        return Long.parseLong(claims.getSubject());
    }

    public String extractRole(String token) {
        Claims claims = parseClaims(token);
        return claims.get("role").toString();
    }

    public Claims parseClaims(String token) {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

}
