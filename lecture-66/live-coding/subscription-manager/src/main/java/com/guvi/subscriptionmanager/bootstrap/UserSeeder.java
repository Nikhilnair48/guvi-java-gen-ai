package com.guvi.subscriptionmanager.bootstrap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.guvi.subscriptionmanager.model.Role;
import com.guvi.subscriptionmanager.model.User;
import com.guvi.subscriptionmanager.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * What's the purpose? create 3 User objects
 * Dependencies? UserRepository, PasswordEncoder
 *  - id, name, email, passwordHash, roles...
 *  Set up: @Component, implement CLR
 */
@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() > 0) {
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        User user1 = new User(null, "admin", "admin@ex.com",
            passwordEncoder.encode("admin123"), Role.ADMIN, true,
            now);
        User user2 = new User(null, "user", "user@ex.com",
            passwordEncoder.encode("user123"), Role.USER, true,
            now);
        User user3 = new User(null, "support", "support@ex.com",
            passwordEncoder.encode("support123"), Role.SUPPORT, true,
            now);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
