package com.guvi.spring_boot_intro.dto;

import java.util.List;

public class SignupResponse {

    private String id;
    private String name;
    private String email;
    private List<String> roles;
    private boolean active;

    public SignupResponse(String id, String name, String email, List<String> roles,
                          boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
