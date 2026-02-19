package com.guvi.spring_boot_intro.repo;

import java.util.List;
import java.util.Optional;

import com.guvi.spring_boot_intro.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    // Optional<Student> fetchByEmailIgnoreCase(String email); -> this will fail

    // key fields we care about: name, email & active
    // we want to search in a case-insensitive manner AND
        // handle partial searches
    // filter by the active
    /*
    findBy
        Active And NameContainingIgnoreCase
            Or
        Active And EmailContainingIgnoreCase
     */
    Page<Student> findByActiveAndNameContainingIgnoreCaseOrActiveAndEmailContainingIgnoreCase(
        boolean active1,
        String namePart,
        boolean active2,
        String emailPart,
        Pageable pageable
    );

    // key fields we care about: name and email
    // we want to search + filter in a case-insensitive manner AND
        // handle partial searches
    Page<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String namePart,
            String emailPart,
            Pageable pageable
    );

    Page<Student> findByActive(boolean active, Pageable pageable);

}
