package com.guvi.spring_boot_intro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enrollments")
public class Enrollment {

    @Id
    private String id;

    private String studentId;
    private String courseId;
    private String status;     // Example values: ACTIVE, PAUSED, COMPLETED
    private String enrolledAt; // Keep as YYYY-MM-DD for now

    public Enrollment() {
    }

    public Enrollment(String studentId, String courseId, String status, String enrolledAt) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.enrolledAt = enrolledAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(String enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    @Override
    public String toString() {
        return "Enrollment{id='" + id + "', studentId='" + studentId + "', courseId='" + courseId
            + "', status='" + status + "', enrolledAt='" + enrolledAt + "'}";
    }
}
