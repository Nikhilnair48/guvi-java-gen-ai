package com.guvi.model;

/**
 * Lifecycle for an Event.
 *
 * Why we need this:
 * - A boolean "active" flag is too weak once we start modelling real flows.
 * - These states give us meaningful business rules (e.g., only PUBLISHED can be booked).
 *
 * Strict transitions are enforced in EventService.
 */
public enum EventStatus {
    DRAFT,
    PUBLISHED,
    CANCELLED
}
