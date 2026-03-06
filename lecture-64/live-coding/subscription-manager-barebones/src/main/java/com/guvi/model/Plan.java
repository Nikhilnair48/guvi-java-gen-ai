package com.guvi.model;

import java.time.LocalDateTime;

/**
 * In-memory model for the baseline.
 *
 * TODO (session): Convert to JPA entity when MySQL integration is added.
 */
public class Plan {

    private String id;
    private String planCode;
    private String name;
    private BillingCycle billingCycle;
    private double price;
    private boolean active;
    private LocalDateTime createdAt;

    public Plan() {}

    public Plan(String id, String planCode, String name, BillingCycle billingCycle, double price, boolean active) {
        this.id = id;
        this.planCode = planCode;
        this.name = name;
        this.billingCycle = billingCycle;
        this.price = price;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
