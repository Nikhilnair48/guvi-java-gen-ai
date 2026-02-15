package com.guvi.spring_boot_intro.controller;

import java.util.List;

import com.guvi.spring_boot_intro.dto.CourseCreateRequest;
import com.guvi.spring_boot_intro.dto.CourseUpdateRequest;
import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody CourseCreateRequest req) {
        Course created = courseService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable String id) {
        return courseService.getById(id);
    }

    @GetMapping("/code/{code}")
    public Course getByCode(@PathVariable String code) {
        return courseService.getByCode(code);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable String id, @RequestBody CourseUpdateRequest req) {
        return courseService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}