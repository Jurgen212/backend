package com.midefensa.midefensaapp.controllers;

import com.midefensa.midefensaapp.services.interfaces.CorreoTribunalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/midefensa/correoTribunal")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CorreoTribunalController {
    private final CorreoTribunalService correoTribunalService;

    public CorreoTribunalController(CorreoTribunalService correoTribunalService) {
        this.correoTribunalService = correoTribunalService;
    }

}
