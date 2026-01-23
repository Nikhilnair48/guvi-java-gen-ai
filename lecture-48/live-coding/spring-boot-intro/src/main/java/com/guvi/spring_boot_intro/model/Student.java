package com.guvi.spring_boot_intro.model;

import java.util.UUID;

public class Student {
    // TODO:
    // Fields: UUID id, String name, String email
    // Constructor: Student(UUID id, String name, String email)
    // Getters
    // toString()

    private final UUID id;
    private final String name;
    private final String email;

    public Student(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
