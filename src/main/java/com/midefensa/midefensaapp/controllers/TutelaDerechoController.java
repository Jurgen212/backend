package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.services.interfaces.TutelaDerechoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midefensa/tutelaDerecho")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class TutelaDerechoController {
    private final TutelaDerechoService tutelaDerechoService;

    public TutelaDerechoController(TutelaDerechoService tutelaDerechoService) {
        this.tutelaDerechoService = tutelaDerechoService;
    }

}
