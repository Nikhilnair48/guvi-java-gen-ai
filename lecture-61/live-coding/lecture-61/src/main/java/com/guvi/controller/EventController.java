package com.guvi.controller;

import java.time.LocalDate;
import java.util.List;

import com.guvi.model.Event;
import com.guvi.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // View the events
    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // View the events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/search")
    public List<Event> searchEvents(
        @RequestParam(required = false) String location,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) LocalDate date
    ) {
        return eventService.searchEvents(location, name, date);
    }
}
