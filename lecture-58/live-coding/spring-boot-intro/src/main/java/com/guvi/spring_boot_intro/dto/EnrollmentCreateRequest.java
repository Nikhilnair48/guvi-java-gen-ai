package com.guvi.spring_boot_intro.dto;

public class EnrollmentCreateRequest {
    private String studentId;
    private String courseId;
    private String status; // optional, defaults to ACTIVE

    public EnrollmentCreateRequest() {}

    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public String getStatus() { return status; }

    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public void setStatus(String status) { this.status = status; }
}