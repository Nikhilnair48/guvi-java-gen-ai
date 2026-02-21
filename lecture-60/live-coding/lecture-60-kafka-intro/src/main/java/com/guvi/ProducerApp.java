package com.guvi;

import java.awt.TexturePaint;
import java.time.Instant;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

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
        String bootstrapServer = "localhost:9092";
        String topic = "guvi.events";

        Properties props = new Properties();
        // props.put("bootstrap.servers", bootstrapServer);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        String[] courseIds =  { "Java", "Spring", "DSA" };
        String[] studentIds =  { "Malini", "Ashik", "Sridhar" };

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        // Sends 15 messages so we can observe repeating keys
        for(var i = 0; i < 15; i++) {
            // (int) Math.random() * 2
            String key = courseIds[i % courseIds.length];
            String studentId = studentIds[i % studentIds.length];

            String value =  "{"
                + "\"eventId\":\"" + UUID.randomUUID() + "\","
                + "\"courseId\":\"" + key + "\","
                + "\"studentId\":\"" + studentId + "\","
                + "\"occurredAt\":\"" + Instant.now() + "\","
                + "}";

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        }
    }
}
