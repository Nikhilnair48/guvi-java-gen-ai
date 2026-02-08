package com.guvi.spring_boot_intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Create the global security rules
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth ->
                auth
                // public endpoints: /auth/login, /auth/signup
                // .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/**", "/auth/login").permitAll()
                // Protect everything else: /api/**
                    .requestMatchers("/api/**").authenticated()
                    .anyRequest().permitAll()
            )
            // basic authentication (Authorization: Basic...)
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
