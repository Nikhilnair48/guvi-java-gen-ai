package com.guvi.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.guvi.model.Event;
import com.guvi.repo.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        event.setStatus(true);
        event.setCreatedAt(LocalDateTime.now());
        event.setRemainingSeats(event.getTotalSeats());
        return eventRepository.save(event);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event Not Found"));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> searchEvents(String location, String title, LocalDate eventDate) {
        // if title is present -> search by location
        // title is "     "
        if(title != null && !title.isBlank()) {
            return eventRepository.findByNameContainingIgnoreCase(title);
        }
        // if location is present -> search by title
        if(location != null) {
            return eventRepository.findByLocation(location);
        }
        // if eventDate is present -> search by eventDate
        if(eventDate != null) {
            return eventRepository.findByEventDate(eventDate);
        }

        // default: return ALL events
        return eventRepository.findAll();
    }
}
