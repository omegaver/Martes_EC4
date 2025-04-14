package com.example.usereventproducer.service;

import com.example.usereventproducer.model.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducerService {

    private static final Logger logger = LoggerFactory.getLogger(UserEventProducerService.class);
    private static final String TOPIC = "user_eventos";

    @Autowired
    private KafkaTemplate<String, UserEvent> kafkaTemplate;

    public void sendMessage(UserEvent event) {
        logger.info(String.format("Enviando evento => %s al tópico %s", event, TOPIC));
        kafkaTemplate.send(TOPIC, event);
    }
}