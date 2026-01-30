package com.guvi.spring_boot_intro.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.guvi.spring_boot_intro.dto.CreateStudentRequest;
import com.guvi.spring_boot_intro.dto.StudentPageResponse;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/students")
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
    // Query parameters to accept: name, email, active, sortBy, sortDir, page, size
    // /students?email=@example.com
//    @GetMapping()
//    public StudentPageResponse listStudents(
//        @RequestParam(required = false) String name,
//        @RequestParam(required = false) String email,
//        @RequestParam(required = false) Boolean active,
//        @RequestParam(required = false) String sortBy,
//        @RequestParam(required = false) String sortDir,
//        @RequestParam(required = false) Integer page,
//        @RequestParam(required = false) Integer size
//    ) {
//        return studentService.searchStudents(name, email, active, sortBy, sortDir, page, size);
//    }
//
//    // method: GET /students/{id} -> -> a student?
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable UUID id) {
//        return studentService.getStudentById(id);
//    }

    // method: POST /students -> status?
    // @Valid after adding jakarta as a dependency
    @PostMapping()
    public ResponseEntity<Student> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student created = studentService.createStudent(request.getName(), request.getEmail());
        return ResponseEntity.status(201).body(created);
    }

//    // new method to update a student
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable UUID id, @Valid @RequestBody CreateStudentRequest request) {
//        // student service will be invoked
//        return studentService.updateStudent(id, request.getEmail(), request.getName());
//            // receive the updated Student
//        // return updated student
//    }
//
//    // Delete a student
//    // @DeleteMapping
//    // Delete a student by their ID
//    // Student service: a method to perform a deletion
//    // Any changes to the store?
//    // What should the API return?
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable UUID id) {
//        studentService.deleteStudent(id);
//    }
}
