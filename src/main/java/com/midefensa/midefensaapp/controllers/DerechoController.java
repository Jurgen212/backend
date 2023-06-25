package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.services.interfaces.DerechoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midefensa/derecho")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class DerechoController {
    private final DerechoService derechoService;

    public DerechoController(DerechoService derechoService) {
        this.derechoService = derechoService;
    }

}
