package com.guvi.spring_boot_intro.dto;

public class EnrollmentStatusUpdateRequest {
    private String status; // e.g., ACTIVE / CANCELLED

    public EnrollmentStatusUpdateRequest() {}

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}