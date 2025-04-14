package com.example.usereventproducer.controller;

import com.example.usereventproducer.model.UserEvent; // Importa la clase UserEvent
import com.example.usereventproducer.service.UserEventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserEventController {

    @Autowired
    private UserEventProducerService producerService;

    @GetMapping("/evento")
    public ResponseEntity<String> getEvent(
            @RequestParam("usuarioId") int usuarioId,
            @RequestParam("accion") String accion,
            @RequestParam("pagina") String pagina) {
        UserEvent event = new UserEvent(usuarioId, accion, pagina); // Crea el objeto UserEvent con los parámetros
        producerService.sendMessage(event);
        return new ResponseEntity<>("Evento recibido (GET) y enviado a Kafka", HttpStatus.OK);
    }
}