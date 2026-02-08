package com.guvi.spring_boot_intro.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enrollments")
public class Enrollment {

    @Id // maps to MongoDB _id
    private String id;

    private String studentId;
    private String courseId;

    private Instant enrolledAt;

    // Example values: "ACTIVE", "CANCELLED"
    private String status;

    public Enrollment(String id, String studentId, String courseId, Instant enrolledAt, String status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public Instant getEnrolledAt() {
        return enrolledAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setEnrolledAt(Instant enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", enrolledAt=" + enrolledAt +
                ", status='" + status + '\'' +
                '}';
    }
}