package com.guvi.spring_boot_intro.service;

import java.util.List;

import com.guvi.spring_boot_intro.dto.LoginRequest;
import com.guvi.spring_boot_intro.dto.LoginResponse;
import com.guvi.spring_boot_intro.dto.SignupRequest;
import com.guvi.spring_boot_intro.dto.SignupResponse;
import com.guvi.spring_boot_intro.exception.DuplicateEmailException;
import com.guvi.spring_boot_intro.exception.InvalidCredentialsException;
import com.guvi.spring_boot_intro.model.User;
import com.guvi.spring_boot_intro.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = passwordEncoder;
    }

    // email: NiKHil@example.com
    // existing user with email: nikhil@example.com
    public SignupResponse signup(SignupRequest request) {
        String name = request.getName();
        String email = request.getEmail().toLowerCase();
        String password = request.getPassword();

        if(userRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail());
        }

        // hashing the password
        String passwordHash = bCryptPasswordEncoder.encode(password);

        // Default role for new signups: STUDENT
        List<String> roles = List.of("STUDENT");
        User user = new User(null, name, email, passwordHash, roles, true);
        User savedUser = userRepository.save(user);

        return new SignupResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getRoles(),
            savedUser.isActive()
        );

    }

    public LoginResponse login(LoginRequest request) {
        String email = request.getEmail().toLowerCase();
        String password = request.getPassword();

        // find the user by email
        // if not found -> InvalidCredentialsException
        User user = userRepository
            .findByEmailIgnoreCase(email)
            .orElseThrow(InvalidCredentialsException::new);

        // consider: what if the user is inactive?

        // check with the bcrypt-encoder -> does the hashed pass match the input password?
        // if not found -> InvalidCredentialsException
        boolean ok = bCryptPasswordEncoder.matches(password, user.getPasswordHash());
        if(!ok) {
            throw new InvalidCredentialsException();
        }

        // return LoginResponse
        return new LoginResponse(
            "Login succesful",
            user.getEmail(),
            user.getRoles()
        );
    }
}
