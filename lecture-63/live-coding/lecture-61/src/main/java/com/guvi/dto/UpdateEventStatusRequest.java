package com.guvi.dto;

import com.guvi.model.EventStatus;

/**
 * Request body for updating an Event's status.
 */
public class UpdateEventStatusRequest {
    private EventStatus status;

    public UpdateEventStatusRequest() {}

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
