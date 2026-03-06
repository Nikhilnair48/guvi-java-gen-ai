package com.guvi.dto;

import jakarta.validation.constraints.NotBlank;

public class SubscribeRequest {

    @NotBlank
    private String planCode;

    private boolean autoRenew = true;

    public SubscribeRequest() {}

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }
}
