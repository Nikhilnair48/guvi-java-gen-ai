package com.guvi.subscriptionmanager.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// JWT token: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30"
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException {
        // retrieve "Authorization" header from the request
        String header = request.getHeader("Authorization");

        // handle validations: if header doesn't exist, blank, etc
        if(header == null || header.isBlank()) {
            // pass
            filterChain.doFilter(request, response);
            return;
        }

        // Extract the token, eliminating the "Bearer "
        String token = header.substring("Bearer ".length());

        // validate the token - need to use JwtUtil
        // if it's invalid
        if(!jwtUtil.isTokenValid(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Set the identity in security context holder
        // extract from the token: userId & role
        Long userId = jwtUtil.extractUserId(token);
        String role = jwtUtil.extractRole(token);

        // Convert the role into a Spring Security Authority: ROLE_ADMIN, ROLE_SUPPORT or ROLE_USER
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        // Store the user identity in Security Context Holder
        UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken(String.valueOf(userId), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }
}
