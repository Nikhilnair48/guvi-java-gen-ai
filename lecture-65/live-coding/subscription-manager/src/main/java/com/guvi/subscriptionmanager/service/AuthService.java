package com.guvi.subscriptionmanager.service;

import com.guvi.subscriptionmanager.config.JwtUtil;
import com.guvi.subscriptionmanager.dto.LoginRequest;
import com.guvi.subscriptionmanager.dto.LoginResponse;
import com.guvi.subscriptionmanager.exception.InvalidCredentialsException;
import com.guvi.subscriptionmanager.model.User;
import com.guvi.subscriptionmanager.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // what're the dependencies?
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        // input: email + password

        // find user by email
        User user = userRepository.findByEmailIgnoreCase(request.getEmail())
            // if not found, throw exception
            .orElseThrow(() -> new InvalidCredentialsException());

        boolean ok = bCryptPasswordEncoder.matches(request.getPassword(), user.getPasswordHash());
        // if password doesn't match (bCryptPasswordEncoder)
        if(!ok) {
            throw new InvalidCredentialsException();
        }

        // generate then Jwt Token
        String token = jwtUtil.generateToken(user.getId(), user.getRole());
        return new LoginResponse(token, user.getId(), user.getRole().name());
    }
}
