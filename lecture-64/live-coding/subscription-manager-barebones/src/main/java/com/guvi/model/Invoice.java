package com.guvi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * In-memory model for the baseline.
 *
 * TODO (session): Convert to JPA entity when MySQL integration is added.
 */
public class Invoice {

    private String id;
    private String subscriptionId;

    private LocalDate periodStart;
    private LocalDate periodEnd;

    private double amount;

    private InvoiceStatus status;

    private LocalDate dueDate;
    private LocalDateTime paidAt;

    private LocalDateTime createdAt;

    public Invoice() {}

    public Invoice(String id, String subscriptionId, LocalDate periodStart, LocalDate periodEnd, double amount) {
        this.id = id;
        this.subscriptionId = subscriptionId;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.amount = amount;
        this.status = InvoiceStatus.DUE;
        this.dueDate = periodStart;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
