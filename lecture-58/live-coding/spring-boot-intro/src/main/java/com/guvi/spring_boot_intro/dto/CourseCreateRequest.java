package com.guvi.spring_boot_intro.dto;

public class CourseCreateRequest {
    private String title;
    private String code;
    private Boolean active;

    public CourseCreateRequest() {}

    public String getTitle() { return title; }
    public String getCode() { return code; }
    public Boolean getActive() { return active; }

    public void setTitle(String title) { this.title = title; }
    public void setCode(String code) { this.code = code; }
    public void setActive(Boolean active) { this.active = active; }
}