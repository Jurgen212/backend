package com.midefensa.midefensaapp.services.implementations;

import com.midefensa.midefensaapp.repositories.TipoDerechoRepository;
import com.midefensa.midefensaapp.services.interfaces.TipoDerechoService;
import org.springframework.stereotype.Service;

@Service
public class TipoDerechoServiceImpl implements TipoDerechoService {
    private final TipoDerechoRepository tipoDerechoRepository;

    public TipoDerechoServiceImpl(TipoDerechoRepository tipoDerechoRepository) {
        this.tipoDerechoRepository = tipoDerechoRepository;
    }

}
