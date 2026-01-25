package com.guvi.spring_boot_intro.exception;

import java.util.UUID;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(UUID id) {
        super("Student Not Found: " + id);
    }
}
