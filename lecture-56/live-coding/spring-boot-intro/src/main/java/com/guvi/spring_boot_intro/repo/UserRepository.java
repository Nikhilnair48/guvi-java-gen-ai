package com.guvi.spring_boot_intro.repo;

import com.guvi.spring_boot_intro.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmailIgnoreCase(String email);
}
