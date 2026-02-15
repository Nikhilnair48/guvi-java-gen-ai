package com.guvi.spring_boot_intro.config;

import java.util.ArrayList;
import java.util.List;

import com.guvi.spring_boot_intro.model.User;
import com.guvi.spring_boot_intro.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MongoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // null check
        String email = username == null ? null : username.trim().toLowerCase();

        // find the email in the users collection
            // if D.N.E (does not exist): throw an exception - UsernameNotFoundException
        User user = userRepository
            .findByEmailIgnoreCase(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // build those authorities - helper method
        List<SimpleGrantedAuthority> authorities = buildAuthorities(user);

        // Build the Spring Security user (username=email, password=passwordHash...)
        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPasswordHash())
            .authorities(authorities)
            .disabled(!user.isActive())
            .build();
    }
    // Conditions:
    // { ..., roles: null }
    // { ..., roles: ["ADMIN", null] }
    // { ..., roles: ["     ", null] }
    // { ..., roles: ["ADMIN    ", null] }
    private List<SimpleGrantedAuthority> buildAuthorities(User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if(user.getRoles() == null) return authorities;

        for(String role: user.getRoles()) {
            if(role == null) continue;
            String trimmedRole = role.trim().toUpperCase();
            if(trimmedRole.isBlank()) continue;

            authorities.add(new SimpleGrantedAuthority("ROLE_" + trimmedRole));
        }

        return authorities;
    }
}
