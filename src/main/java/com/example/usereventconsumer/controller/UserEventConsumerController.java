package com.example.usereventconsumer.controller;

import com.example.usereventconsumer.model.UserEvent;
import com.example.usereventconsumer.service.UserEventConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserEventConsumerController {

    @Autowired
    private UserEventConsumerService consumerService;

    @GetMapping("/eventos")
    public List<UserEvent> getAllUserEvents() {
        return consumerService.getAllEvents();
    }
}