package com.guvi.controller;

import java.time.LocalDate;
import java.util.List;

import com.guvi.dto.CreateEventRequest;
import com.guvi.dto.UpdateEventStatusRequest;
import com.guvi.model.Event;
import com.guvi.service.EventService;
import org.springframework.web.bind.annotation.*;

/**
 * REST endpoints for Events.
 *
 * Note: Pre-session version has NO authentication.
 * We want all APIs stable before introducing auth in the lecture.
 */
@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Create an event (defaults to DRAFT in the service)
    @PostMapping
    public Event create(@RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    // View all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // View single event details
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    // Simple filters (kept intentionally basic)
    @GetMapping("/search")
    public List<Event> searchEvents(
        @RequestParam(required = false) String location,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) LocalDate date
    ) {
        return eventService.searchEvents(location, name, date);
    }

    // Update lifecycle status with strict transition rules.
    @PatchMapping("/{id}/status")
    public Event updateStatus(@PathVariable String id, @RequestBody UpdateEventStatusRequest req) {
        return eventService.updateStatus(id, req.getStatus());
    }
}