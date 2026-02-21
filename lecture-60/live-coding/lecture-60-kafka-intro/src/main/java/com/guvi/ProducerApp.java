package com.guvi;

import java.awt.TexturePaint;
import java.time.Instant;
import java.util.Properties;
import java.util.UUID;

/**
 * Connect to localhost:9092
 * Write messages to guvi.events topic
 * We need to emit events for enrollments to courses
 * Event structure (JSON):
 *      {
 *          "eventId" : "...",
 *          "courseId" : "...",
 *          "studentId" : "...",
 *          "occurredAt" : "..."
 *      }
 * Student Id:
 *  - "Malini", "Ashik", "Sridhar"
 *  Course Id:
 *  - "Java", "Spring", "DSA"
 * Messages we'll send must have a key and value
 */
public class ProducerApp {
    public static void main(String[] args) {
        
    }
}
