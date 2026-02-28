package com.guvi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.guvi.dto.BookingResponse;
import com.guvi.dto.CreateBookingRequest;
import com.guvi.exception.BusinessConflictException;
import com.guvi.exception.ResourceNotFoundException;
import com.guvi.model.Booking;
import com.guvi.model.BookingStatus;
import com.guvi.model.Event;
import com.guvi.model.EventStatus;
import com.guvi.repo.BookingRepository;
import com.guvi.repo.EventRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Handles Booking operations.
 *
 * Pre-session goals:
 * - Booking allowed only when Event is PUBLISHED
 * - Proper errors (404/409) instead of generic RuntimeException
 * - Support cancel booking
 *
 * NOTE: This is still the "naive" seat update (read -> decrement -> save).
 * Race-condition handling will be taught later.
 */
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository, EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }

    /**
     * Book using DTO (not Mongo model).
     *
     * Why:
     * - Avoid JSON parse issues due to primitive int in Booking model.
     * - Keep API contract small and predictable.
     */
    public BookingResponse book(CreateBookingRequest req) {
        // Validations
        if (req == null) {
            throw new IllegalArgumentException("Request body is required");
        }
        if (req.getEventId() == null || req.getEventId().isBlank()) {
            throw new IllegalArgumentException("eventId is required");
        }
        if (req.getNumberOfSeats() == null || req.getNumberOfSeats() <= 0) {
            throw new IllegalArgumentException("numberOfSeats must be > 0");
        }

        String eventId = req.getEventId().trim();
        // retrieves the user email from the SecurityContextHolder
        // we can use the userRepository to retrieve the user by email -> this will give us the userId
        String userId = getCurrentUserId();
        int seatsRequested = req.getNumberOfSeats();

        // Find event
        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        // Business rule: booking allowed only on PUBLISHED events
        if (event.getStatus() != EventStatus.PUBLISHED) {
            throw new BusinessConflictException("Event is not open for booking (status=" + event.getStatus() + ")");
        }

        // For a given user and an event, we only support one CONFIRMED booking (pre-session rule)
        if (bookingRepository.existsByUserIdAndEventIdAndStatus(userId, eventId, BookingStatus.CONFIRMED)) {
            throw new BusinessConflictException("User already has a confirmed booking for this event");
        }

        // Ensure there are sufficient seats
        if (event.getRemainingSeats() < seatsRequested) {
            throw new BusinessConflictException("Not enough seats available");
        }

        // NAIVE seat decrement
        event.setRemainingSeats(event.getRemainingSeats() - seatsRequested);
        eventRepository.save(event);

        // Build booking document
        Booking booking = new Booking();
        booking.setEventId(eventId);
        booking.setUserId(userId);
        booking.setNumberOfSeats(seatsRequested);
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setCreatedAt(LocalDateTime.now());

        Booking saved = bookingRepository.save(booking);
        return toResponse(saved, event);
    }

    /**
     * Returns the authenticated user's id
     * @return
     */
    private String getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user found");
        }

        return authentication.getName();
    }

    public List<BookingResponse> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return enrich(bookings);
    }

    public BookingResponse getBookingById(String id) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        Event event = eventRepository.findById(booking.getEventId())
            .orElseThrow(() -> new ResourceNotFoundException("Event not found for booking"));
        return toResponse(booking, event);
    }

    public List<BookingResponse> getBookingsByEvent(String eventId) {
        return enrich(bookingRepository.findByEventId(eventId));
    }

    /**
     * Convenience method for "my bookings
     * @param userId
     * @return
     */
    public List<BookingResponse> getMyBookings() {
        String userId = getCurrentUserId();
        return getBookingsByUser(userId);
    }

    public List<BookingResponse> getBookingsByUser(String userId) {
        return enrich(bookingRepository.findByUserId(userId));
    }

    public BookingResponse cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        if (booking.getStatus() == BookingStatus.CANCELLED) {
            throw new BusinessConflictException("Booking is already cancelled");
        }

        booking.setStatus(BookingStatus.CANCELLED);
        Booking saved = bookingRepository.save(booking);

        Event event = eventRepository.findById(saved.getEventId())
            .orElseThrow(() -> new ResourceNotFoundException("Event not found for booking"));

        // NOTE: We do NOT increment event.remainingSeats here for simplicity.
        // In real systems this depends on business rules and timing (and can be abused).
        return toResponse(saved, event);
    }

    private List<BookingResponse> enrich(List<Booking> bookings) {
        List<BookingResponse> out = new ArrayList<>();
        for (Booking b : bookings) {
            Event event = eventRepository.findById(b.getEventId()).orElse(null);
            if (event == null) {
                // Keep response stable even if data is inconsistent.
                BookingResponse r = new BookingResponse();
                r.setBookingId(b.getId());
                r.setEventId(b.getEventId());
                r.setUserId(b.getUserId());
                r.setNumberOfSeats(b.getNumberOfSeats());
                r.setBookingStatus(b.getStatus());
                r.setCreatedAt(b.getCreatedAt());
                out.add(r);
            } else {
                out.add(toResponse(b, event));
            }
        }
        return out;
    }

    private BookingResponse toResponse(Booking booking, Event event) {
        BookingResponse r = new BookingResponse();
        r.setBookingId(booking.getId());
        r.setEventId(event.getId());
        r.setEventName(event.getName());
        r.setEventStatus(event.getStatus());
        r.setUserId(booking.getUserId());
        r.setNumberOfSeats(booking.getNumberOfSeats());
        r.setBookingStatus(booking.getStatus());
        r.setCreatedAt(booking.getCreatedAt());
        return r;
    }
}