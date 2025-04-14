package com.example.usereventconsumer.service;

import com.example.usereventconsumer.model.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEventConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(UserEventConsumerService.class);

    private List<UserEvent> storedEvents = new ArrayList<>();

    @KafkaListener(topics = "user_events", groupId = "user-event-consumer-group")
    public void consume(UserEvent event) {
        logger.info(String.format("Evento recibido => %s", event));
        storedEvents.add(event);
    }

    public List<UserEvent> getAllEvents() {
        return storedEvents;
    }
}