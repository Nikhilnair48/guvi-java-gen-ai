package com.guvi.controller;

import java.util.List;

import com.guvi.dto.BookingResponse;
import com.guvi.dto.CreateBookingRequest;
import com.guvi.service.BookingService;
import org.springframework.web.bind.annotation.*;

/**
 * REST endpoints for Bookings.
 *
 * Note: Pre-session version has NO authentication.
 * In Day #50, we'll introduce roles and then replace /user/{userId}
 * with a secure /me endpoint.
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a booking (expects eventId, userId, numberOfSeats in JSON)
    @PostMapping
    public BookingResponse create(@RequestBody CreateBookingRequest request) {
        return bookingService.book(request);
    }

    // Admin-style list (pre-auth: everyone can call; later restrict)
    @GetMapping
    public List<BookingResponse> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingResponse getById(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/event/{eventId}")
    public List<BookingResponse> getByEvent(@PathVariable String eventId) {
        return bookingService.getBookingsByEvent(eventId);
    }

    // Pre-auth endpoint. Will become /me after auth is added.
    @GetMapping("/user/{userId}")
    public List<BookingResponse> getByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/me")
    public List<BookingResponse> getMyBookings() {
        return bookingService.getMyBookings();
    }

    // Cancel (soft cancel)
    @DeleteMapping("/{id}")
    public BookingResponse cancel(@PathVariable String id) {
        return bookingService.cancelBooking(id);
    }
}