package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.services.interfaces.TutelaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midefensa/tutela")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class TutelaController {
    private final TutelaService tutelaService;

    public TutelaController(TutelaService tutelaService) {
        this.tutelaService = tutelaService;
    }

}
