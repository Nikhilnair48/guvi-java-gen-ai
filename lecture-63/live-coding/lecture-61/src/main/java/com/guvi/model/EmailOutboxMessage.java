package com.guvi.model;

import java.time.Instant;

public class EmailOutboxMessage {
    private String id;

    private String toEmail;
    private String subject;
    private String body;

    private EmailStatus status;
    private Instant createdAt;

    public EmailOutboxMessage(String id, String toEmail, String subject, String body,
                              EmailStatus status, Instant createdAt) {
        this.id = id;
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public EmailStatus getStatus() {
        return status;
    }

    public void setStatus(EmailStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
