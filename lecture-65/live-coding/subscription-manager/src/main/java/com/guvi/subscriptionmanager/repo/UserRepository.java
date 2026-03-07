package com.guvi.subscriptionmanager.repo;

import java.util.Optional;

import com.guvi.subscriptionmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);
}

