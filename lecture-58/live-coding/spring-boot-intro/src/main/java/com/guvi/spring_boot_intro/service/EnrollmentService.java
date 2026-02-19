package com.guvi.spring_boot_intro.service;

import java.time.Instant;
import java.util.List;

import com.guvi.spring_boot_intro.dto.EnrollmentCreateRequest;
import com.guvi.spring_boot_intro.dto.EnrollmentStatusUpdateRequest;
import com.guvi.spring_boot_intro.exception.BadRequestException;
import com.guvi.spring_boot_intro.exception.DuplicateResourceException;
import com.guvi.spring_boot_intro.exception.ResourceNotFoundException;
import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.repo.CourseRepository;
import com.guvi.spring_boot_intro.repo.EnrollmentRepository;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment create(EnrollmentCreateRequest req) {
        String studentId = normalize(req.getStudentId());
        String courseId = normalize(req.getCourseId());
        String status = normalize(req.getStatus());

        if (isBlank(studentId)) throw new BadRequestException("studentId is required.");
        if (isBlank(courseId)) throw new BadRequestException("courseId is required.");

        // Optional but good: validate references
        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found for id: " + studentId);
        }
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found for id: " + courseId);
        }

        if (enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new DuplicateResourceException("Enrollment already exists for studentId=" + studentId + " and courseId=" + courseId);
        }

        String finalStatus = isBlank(status) ? "ACTIVE" : status.toUpperCase();
        Enrollment enrollment = new Enrollment(null, studentId, courseId, Instant.now(), finalStatus);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getById(String id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for id: " + id));
    }

    public List<Enrollment> getByStudentId(String studentId) {
        String normalized = normalize(studentId);
        if (isBlank(normalized)) throw new BadRequestException("studentId is required.");
        return enrollmentRepository.findByStudentId(normalized);
    }

    public List<Enrollment> getByCourseId(String courseId) {
        String normalized = normalize(courseId);
        if (isBlank(normalized)) throw new BadRequestException("courseId is required.");
        return enrollmentRepository.findByCourseId(normalized);
    }

    public Enrollment updateStatus(String id, EnrollmentStatusUpdateRequest req) {
        Enrollment existing = getById(id);

        String status = normalize(req.getStatus());
        if (isBlank(status)) throw new BadRequestException("status is required.");

        existing.setStatus(status.toUpperCase());
        return enrollmentRepository.save(existing);
    }

    public void delete(String id) {
        Enrollment existing = getById(id);
        enrollmentRepository.delete(existing);
    }

    private static String normalize(String s) {
        return s == null ? null : s.trim();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}