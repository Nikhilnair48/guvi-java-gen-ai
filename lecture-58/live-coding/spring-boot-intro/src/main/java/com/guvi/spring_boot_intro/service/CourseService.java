package com.guvi.spring_boot_intro.service;

import java.util.List;

import com.guvi.spring_boot_intro.dto.CourseCreateRequest;
import com.guvi.spring_boot_intro.dto.CourseUpdateRequest;
import com.guvi.spring_boot_intro.exception.BadRequestException;
import com.guvi.spring_boot_intro.exception.DuplicateResourceException;
import com.guvi.spring_boot_intro.exception.ResourceNotFoundException;
import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.repo.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(CourseCreateRequest req) {
        String title = normalize(req.getTitle());
        String code = normalize(req.getCode());
        boolean active = req.getActive() != null ? req.getActive() : true;

        if (isBlank(title)) throw new BadRequestException("Course title is required.");
        if (isBlank(code)) throw new BadRequestException("Course code is required.");

        if (courseRepository.existsByCode(code)) {
            throw new DuplicateResourceException("Course with code '" + code + "' already exists.");
        }

        Course course = new Course(null, title, code, active);
        return courseRepository.save(course);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for id: " + id));
    }

    public Course getByCode(String code) {
        String normalized = normalize(code);
        if (isBlank(normalized)) throw new BadRequestException("Course code is required.");

        return courseRepository.findByCode(normalized)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for code: " + normalized));
    }

    public Course update(String id, CourseUpdateRequest req) {
        Course existing = getById(id);

        if (req.getTitle() != null) {
            String title = normalize(req.getTitle());
            if (isBlank(title)) throw new BadRequestException("Course title cannot be empty.");
            existing.setTitle(title);
        }

        if (req.getCode() != null) {
            String code = normalize(req.getCode());
            if (isBlank(code)) throw new BadRequestException("Course code cannot be empty.");

            // If code is changing, enforce uniqueness
            if (!code.equals(existing.getCode()) && courseRepository.existsByCode(code)) {
                throw new DuplicateResourceException("Course with code '" + code + "' already exists.");
            }
            existing.setCode(code);
        }

        if (req.getActive() != null) {
            existing.setActive(req.getActive());
        }

        return courseRepository.save(existing);
    }

    public void delete(String id) {
        Course existing = getById(id);
        courseRepository.delete(existing);
    }

    private static String normalize(String s) {
        return s == null ? null : s.trim();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}