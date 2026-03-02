package com.guvi.exception;

/**
 * Thrown when a resource (Event/Booking/etc.) is not found.
 * Mapped to HTTP 404 in GlobalExceptionHandler.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
