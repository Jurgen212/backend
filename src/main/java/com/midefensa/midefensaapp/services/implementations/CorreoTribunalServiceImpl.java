package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.CorreoTribunalRepository;
import com.midefensa.midefensaapp.services.interfaces.CorreoTribunalService;
import org.springframework.stereotype.Service;

@Service
public class CorreoTribunalServiceImpl implements CorreoTribunalService {
    private final CorreoTribunalRepository correoTribunalRepository;

    public CorreoTribunalServiceImpl(CorreoTribunalRepository correoTribunalRepository) {
        this.correoTribunalRepository = correoTribunalRepository;
    }

}
