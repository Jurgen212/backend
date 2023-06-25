package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.ServicioTutelaRepository;
import com.midefensa.midefensaapp.services.interfaces.ServicioTutelaService;
import org.springframework.stereotype.Service;

@Service
public class ServicioTutelaServiceImpl implements ServicioTutelaService {
    private final ServicioTutelaRepository servicioTutelaRepository;

    public ServicioTutelaServiceImpl(ServicioTutelaRepository servicioTutelaRepository) {
        this.servicioTutelaRepository = servicioTutelaRepository;
    }

}
