package com.guvi.spring_boot_intro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {

    @Id // maps to MongoDB _id
    private String id;

    private String title;

    @Indexed(unique = true)
    private String code;

    private boolean active;

    public Course(String id, String title, String code, boolean active) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", active=" + active +
                '}';
    }
}