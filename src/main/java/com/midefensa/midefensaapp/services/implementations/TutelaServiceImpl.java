package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.TutelaRepository;
import com.midefensa.midefensaapp.services.interfaces.TutelaService;
import org.springframework.stereotype.Service;

@Service
public class TutelaServiceImpl implements TutelaService {
    private final TutelaRepository tutelaRepository;

    public TutelaServiceImpl(TutelaRepository tutelaRepository) {
        this.tutelaRepository = tutelaRepository;
    }

}
