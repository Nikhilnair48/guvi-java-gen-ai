package com.guvi.subscriptionmanager.controller;

import com.guvi.subscriptionmanager.dto.LoginRequest;
import com.guvi.subscriptionmanager.dto.LoginResponse;
import com.guvi.subscriptionmanager.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*
        HTTP Verb? GET, PUT, POST, DELETE
        /login endpoint
            - email + password (LoginRequest)
            - call the login method in the auth service
    */
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }


}
