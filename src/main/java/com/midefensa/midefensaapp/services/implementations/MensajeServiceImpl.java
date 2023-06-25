package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.MensajeRepository;
import com.midefensa.midefensaapp.services.interfaces.MensajeService;
import org.springframework.stereotype.Service;

@Service
public class MensajeServiceImpl implements MensajeService {
    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

}
