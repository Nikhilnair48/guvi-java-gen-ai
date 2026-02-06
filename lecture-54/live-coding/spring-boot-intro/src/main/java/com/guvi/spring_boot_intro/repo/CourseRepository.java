package com.guvi.spring_boot_intro.repo;

import java.util.Optional;

import com.guvi.spring_boot_intro.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByTitleIgnoreCase(String title);
    boolean existsByTitleIgnoreCase(String title);
}
