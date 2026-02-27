package com.guvi.repo;

import java.time.LocalDate;
import java.util.List;

import com.guvi.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByLocation(String location);
    List<Event> findByEventDate(LocalDate eventDate);
    // case insensitive search + partial search (eg: "concert")
    List<Event> findByNameContainingIgnoreCase(String name);
}
