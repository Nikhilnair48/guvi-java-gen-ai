package com.guvi.spring_boot_intro.controller;

import com.guvi.spring_boot_intro.dto.SignupRequest;
import com.guvi.spring_boot_intro.dto.SignupResponse;
import com.guvi.spring_boot_intro.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // POST /signup
    // SignupRequest
    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody SignupRequest request) {
        SignupResponse response = authService.signup(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }
}
