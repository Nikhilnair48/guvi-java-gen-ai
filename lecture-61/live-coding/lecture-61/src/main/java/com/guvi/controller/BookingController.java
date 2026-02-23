package com.guvi.controller;

import java.util.List;

import com.guvi.model.Booking;
import com.guvi.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // creating a booking

    // get "my bookings"
    @GetMapping("/{id}")
    public List<Booking> getMyBookings() {

    }
}
