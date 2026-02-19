package com.guvi.spring_boot_intro.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) {
        super("Student Not Found: " + id);
    }
}
