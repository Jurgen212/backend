package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.TutelaDerechoRepository;
import com.midefensa.midefensaapp.services.interfaces.TutelaDerechoService;
import org.springframework.stereotype.Service;

@Service
public class TutelaDerechoServiceImpl implements TutelaDerechoService {
    private final TutelaDerechoRepository tutelaDerechoRepository;

    public TutelaDerechoServiceImpl(TutelaDerechoRepository tutelaDerechoRepository) {
        this.tutelaDerechoRepository = tutelaDerechoRepository;
    }

}
