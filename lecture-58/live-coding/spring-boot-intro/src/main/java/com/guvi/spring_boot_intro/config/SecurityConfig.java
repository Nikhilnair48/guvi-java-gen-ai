package com.guvi.spring_boot_intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Create the global security rules
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth ->
                auth

                    // public endpoints: /auth/login, /auth/signup
                    .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()

                    /*
                        Courses specific
                        Roles: STUDENT, ADMIN
                        1. GET /api/courses, /api/courses/** - authenticated user
                        2. POST /api/courses - authenticated and ADMIN
                        3. PUT /api/courses - authenticated and ADMIN
                        4. DELETE /api/courses/, /api/courses/** - authenticated and ADMIN
                     */
                    .requestMatchers(HttpMethod.GET, "/api/courses", "/api/courses/**").authenticated()
                    // hasRole: must be authenticated AND must have the ROLE_ADMIN
                    .requestMatchers(HttpMethod.POST, "/api/courses").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/courses", "/api/courses/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/courses", "/api/courses/**").hasRole("ADMIN")

                    // Protect everything else: /api/**
                    .requestMatchers("/api/**").authenticated()
                    // /students endpoints are public
                    .anyRequest().permitAll()
            )
            // basic authentication (Authorization: Basic...)
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
