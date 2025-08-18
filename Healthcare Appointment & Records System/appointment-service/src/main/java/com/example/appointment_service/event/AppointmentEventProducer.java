package com.example.appointment_service.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventProducer {
    private final KafkaTemplate<String,String> kafka;
    public static final String TOPIC_CONFIRMED = "appointment-confirmed";
    public static final String TOPIC_CANCELLED = "appointment-cancelled";
    public static final String TOPIC_COMPLETED = "appointment-completed";

    public AppointmentEventProducer(KafkaTemplate<String,String> kafka){ this.kafka = kafka; }

    public void publish(String topic, String payload){ kafka.send(topic, payload); }
}