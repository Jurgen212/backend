package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.DerechoRepository;
import com.midefensa.midefensaapp.services.interfaces.DerechoService;
import org.springframework.stereotype.Service;

@Service
public class DerechoServiceImpl implements DerechoService {
    private final DerechoRepository derechoRepository;

    public DerechoServiceImpl(DerechoRepository derechoRepository) {
        this.derechoRepository = derechoRepository;
    }

}
