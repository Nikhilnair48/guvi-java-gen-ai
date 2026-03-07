package com.guvi.subscriptionmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(auth -> auth
            // Auth endpoints are public
            .requestMatchers("/auth/**").permitAll()

            // Plans browsing is public
            .requestMatchers(HttpMethod.GET, "/plans/**").permitAll()

            // Role-based routes
            .requestMatchers(HttpMethod.POST,"/subscriptions/**").hasRole("ADMIN")
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/support/**").hasRole("SUPPORT")

            // Everything else requires authentication
            .anyRequest().authenticated()
        );

        return http.build();
    }
}