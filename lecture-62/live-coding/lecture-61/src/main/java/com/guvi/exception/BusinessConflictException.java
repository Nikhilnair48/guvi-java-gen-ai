package com.guvi.exception;

/**
 * Thrown when the request is valid, but violates a business rule.
 * Examples:
 * - booking on a non-PUBLISHED event
 * - not enough seats
 * - invalid status transition
 *
 * Mapped to HTTP 409 in GlobalExceptionHandler.
 */
public class BusinessConflictException extends RuntimeException {
    public BusinessConflictException(String message) {
        super(message);
    }
}
