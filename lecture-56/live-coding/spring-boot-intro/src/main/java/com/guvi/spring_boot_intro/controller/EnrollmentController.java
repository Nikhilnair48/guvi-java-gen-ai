package com.guvi.spring_boot_intro.controller;

import java.util.List;

import com.guvi.spring_boot_intro.dto.EnrollmentCreateRequest;
import com.guvi.spring_boot_intro.dto.EnrollmentStatusUpdateRequest;
import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody EnrollmentCreateRequest req) {
        Enrollment created = enrollmentService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Enrollment> getAll() {
        return enrollmentService.getAll();
    }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable String id) {
        return enrollmentService.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getByStudentId(@PathVariable String studentId) {
        return enrollmentService.getByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getByCourseId(@PathVariable String courseId) {
        return enrollmentService.getByCourseId(courseId);
    }

    @PutMapping("/{id}/status")
    public Enrollment updateStatus(@PathVariable String id, @RequestBody EnrollmentStatusUpdateRequest req) {
        return enrollmentService.updateStatus(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}