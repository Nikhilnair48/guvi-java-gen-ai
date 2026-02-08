package com.guvi.spring_boot_intro.repo;

import java.util.List;
import java.util.Optional;

import com.guvi.spring_boot_intro.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {

    Optional<Enrollment> findByStudentIdAndCourseId(String studentId, String courseId);

    boolean existsByStudentIdAndCourseId(String studentId, String courseId);

    List<Enrollment> findByStudentId(String studentId);

    List<Enrollment> findByCourseId(String courseId);
}
