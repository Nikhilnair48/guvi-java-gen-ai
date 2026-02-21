package com.guvi;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * Our consumer will track the number of enrollments for each course
 * Java: 4
 * Spring: 40
 */
public class ConsumerApp {
    public static void main(String[] args) {
        String bootstrapServer = "localhost:9092";
        String topic = "guvi.events";
        // Defines the consumer group ID (Kafka will track the offsets per consumer group)
        String groupId = "partition-guvi-v1";

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of(topic));

    }
}
