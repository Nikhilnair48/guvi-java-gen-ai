package com.guvi.config;

import java.util.List;

import com.guvi.model.User;
import com.guvi.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// This needs to run when the server starts up to populate the users collection
// populate the user collection using the user repo
// encoder to generate password hash
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() > 0) {
            return;
        }

        // Admin
        User admin = new User(null, "admin@ex.com",
            passwordEncoder.encode("admin123"), List.of("ADMIN"),
            true);
        // Organizer
        User organizer = new User(null, "organizer@ex.com",
            passwordEncoder.encode("org123"), List.of("ORGANIZER"),
            true);
        // User
        User user = new User(null, "user@ex.com",
            passwordEncoder.encode("user123"), List.of("USER"),
            true);

        userRepository.saveAll(List.of(admin, organizer, user));
    }
}
