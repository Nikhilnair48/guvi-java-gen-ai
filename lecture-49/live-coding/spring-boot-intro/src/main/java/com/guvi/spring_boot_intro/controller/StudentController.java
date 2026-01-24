package com.guvi.spring_boot_intro.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.guvi.spring_boot_intro.dto.CreateStudentRequest;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * List students
 * GET /students
 * Get a student by id
 * GET /students/{id}
 * Create a student
 * POST /students
 * How will the HTTP requests look?
 */
@RestController
public class StudentController {
    // need an instance of the StudentService
        // a instance variable: StudentService studentService
        // public StudentController(..) { ... }
    private final StudentService studentService;
    // http://localhost:9000/students
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // @RequestMapping
    // method: GET /students -> List<Student>
    @GetMapping("/students")
    public List<Student> listStudents() {
        List<Student> students = studentService.listStudents();
        return students;
    }

    // method: GET /students/{id} -> -> a student?
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    // method: POST /students -> status?
    // @Valid after adding jakarta as a dependency
    @PostMapping("/students")
    public ResponseEntity<Optional<Student>> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Optional<Student> created = studentService.createStudent(request.getName(), request.getEmail());
        return ResponseEntity.status(201).body(created);
    }
    // http://localhost:9000/students
}
