package com.guvi.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.guvi.dto.CreateEventRequest;
import com.guvi.exception.BusinessConflictException;
import com.guvi.exception.ResourceNotFoundException;
import com.guvi.model.Booking;
import com.guvi.model.BookingStatus;
import com.guvi.model.Event;
import com.guvi.model.EventStatus;
import com.guvi.repo.BookingRepository;
import com.guvi.repo.EventRepository;
import org.springframework.stereotype.Service;

/**
 * Handles Event-related operations.
 *
 * Pre-session goal:
 * - Introduce a real Event lifecycle (DRAFT -> PUBLISHED -> CANCELLED)
 * - Enforce strict transitions
 * - Cancel all confirmed bookings when an event is cancelled
 *
 * NOTE: No auth/Kafka here yet. This is purely business logic.
 */
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final BookingRepository bookingRepository;

    public EventService(EventRepository eventRepository, BookingRepository bookingRepository) {
        this.eventRepository = eventRepository;
        this.bookingRepository = bookingRepository;
    }

    /**
     * Create event from DTO (not from Mongo model).
     *
     * Why:
     * - Prevent JSON parsing issues caused by primitives in the Event model.
     * - Prevent client from sending system-managed fields.
     */
    public Event createEvent(CreateEventRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("Request body is required");
        }
        if (req.getName() == null || req.getName().isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (req.getLocation() == null || req.getLocation().isBlank()) {
            throw new IllegalArgumentException("location is required");
        }
        if (req.getEventDate() == null) {
            throw new IllegalArgumentException("eventDate is required");
        }
        if (req.getTotalSeats() == null || req.getTotalSeats() <= 0) {
            throw new IllegalArgumentException("totalSeats must be > 0");
        }

        Event event = new Event();
        event.setName(req.getName().trim());
        event.setLocation(req.getLocation().trim());
        event.setEventDate(req.getEventDate());
        event.setTotalSeats(req.getTotalSeats());

        // System-managed fields
        event.setStatus(EventStatus.DRAFT);
        event.setCreatedAt(LocalDateTime.now());
        event.setRemainingSeats(req.getTotalSeats());

        // price not used in pre-session → keep a safe default
        event.setPrice(0.0f);

        return eventRepository.save(event);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Simple search (kept intentionally basic for learners).
     * Priority order:
     * 1) name contains (case-insensitive)
     * 2) location exact match
     * 3) date exact match
     * 4) else return all
     */
    public List<Event> searchEvents(String location, String title, LocalDate eventDate) {
        if (title != null && !title.isBlank()) {
            return eventRepository.findByNameContainingIgnoreCase(title.trim());
        }
        if (location != null && !location.isBlank()) {
            return eventRepository.findByLocation(location.trim());
        }
        if (eventDate != null) {
            return eventRepository.findByEventDate(eventDate);
        }
        return eventRepository.findAll();
    }

    /**
     * Update event status with STRICT transitions.
     *
     * Allowed:
     * - DRAFT -> PUBLISHED
     * - PUBLISHED -> CANCELLED
     *
     * Not allowed:
     * - CANCELLED -> anything
     * - DRAFT -> CANCELLED (we keep it strict/simpler for teaching)
     * - PUBLISHED -> DRAFT
     */
    public Event updateStatus(String eventId, EventStatus newStatus) {
        Event event = getEventById(eventId);
        EventStatus current = event.getStatus();

        if (newStatus == null) {
            throw new IllegalArgumentException("status is required");
        }

        // Strict transition rules
        if (current == EventStatus.DRAFT && newStatus == EventStatus.PUBLISHED) {
            event.setStatus(EventStatus.PUBLISHED);
            return eventRepository.save(event);
        }

        if (current == EventStatus.PUBLISHED && newStatus == EventStatus.CANCELLED) {
            event.setStatus(EventStatus.CANCELLED);
            Event saved = eventRepository.save(event);

            // Cascade: cancel all confirmed bookings for this event.
            List<Booking> confirmed = bookingRepository.findByEventIdAndStatus(eventId, BookingStatus.CONFIRMED);
            for (Booking b : confirmed) {
                b.setStatus(BookingStatus.CANCELLED);
                bookingRepository.save(b);
            }

            return saved;
        }

        // Everything else is invalid
        throw new BusinessConflictException("Invalid status transition: " + current + " -> " + newStatus);
    }
}