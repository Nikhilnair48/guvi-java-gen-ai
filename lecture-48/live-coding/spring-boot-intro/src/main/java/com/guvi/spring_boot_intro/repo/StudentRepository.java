package com.guvi.spring_boot_intro.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.guvi.spring_boot_intro.model.Student;

public interface StudentRepository {
    // TODO: understand why we use an interface here.

    void save(Student student);

    Optional<Student> findById(UUID id);

    List<Student> findAll();

    Optional<Student> findByEmail(String email);

}
