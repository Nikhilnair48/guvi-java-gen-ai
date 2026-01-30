package com.guvi.spring_boot_intro.repo;

import java.util.Optional;

import com.guvi.spring_boot_intro.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // findByEmail -> 1) test@gmail.com, 2) TEST@gmail.com -> exception

    /**
        Spring Data parses the method name to derive the query to be executed on the DB
            - Prefix: findBy, existsBy, deleteBy...
            - Property (aka field): Email -> matching field/getter on Student
            - Keywords/operators: IgnoreCase, Between, In, Like, OrderBy, etc

        findByEmailIgnoreCase ->
                - action: find
                - field: email
                - case-insensitive match
                - value - method argument
     */
    Optional<Student> findByEmailIgnoreCase(String email);
    // Optional<Student> fetchByEmailIgnoreCase(String email);

}
