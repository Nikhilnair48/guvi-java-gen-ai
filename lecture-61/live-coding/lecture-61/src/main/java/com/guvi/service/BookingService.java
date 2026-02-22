package com.guvi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.guvi.model.Booking;
import com.guvi.model.BookingStatus;
import com.guvi.model.Event;
import com.guvi.repo.BookingRepository;
import com.guvi.repo.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository, EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }

    public Booking book(Booking booking) {
        // Find event
        Event event = eventRepository.findById(booking.getEventId())
            .orElseThrow(() -> new RuntimeException("Event not found"));

        // For a given user and an event, we only support one booking
        if(bookingRepository.existsByUserIdAndEventIdAndStatus(booking.getUserId(), booking.getEventId(),
            BookingStatus.CONFIRMED)) {
            throw new RuntimeException("User already has booking for this event");
        }

        // Ensure there're sufficient seats for the booking
        if(event.getRemainingSeats() < booking.getNumberOfSeats()) {
            throw new RuntimeException("Not enough seats available");
        }

        // Decrement the seat count (remainingSeats for the event) for the event
        event.setRemainingSeats(event.getRemainingSeats() - booking.getNumberOfSeats());
        eventRepository.save(event);

        // Create a booking
        booking.setStatus(BookingStatus.CONFIRMED);;
        booking.setCreatedAt(LocalDateTime.now());

        // save
        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(String userId) {
        return bookingRepository.findByUserId(userId);
    }
}
