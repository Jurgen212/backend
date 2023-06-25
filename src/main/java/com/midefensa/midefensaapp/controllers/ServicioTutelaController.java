package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.services.interfaces.ServicioTutelaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midefensa/servicioTutela")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ServicioTutelaController {
    private final ServicioTutelaService servicioTutelaService;

    public ServicioTutelaController(ServicioTutelaService servicioTutelaService) {
        this.servicioTutelaService = servicioTutelaService;
    }

}
