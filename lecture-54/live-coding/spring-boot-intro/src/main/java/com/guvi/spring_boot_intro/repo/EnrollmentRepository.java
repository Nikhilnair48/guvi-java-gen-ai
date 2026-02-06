package com.guvi.spring_boot_intro.repo;

import java.util.List;

import com.guvi.spring_boot_intro.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    List<Enrollment> findByStudentId(String studentId);
    List<Enrollment> findByCourseId(String courseId);
    List<Enrollment> findByStudentIdAndStatus(String studentId, String status);
    boolean existsByStudentIdAndCourseId(String studentId, String courseId);
}
