package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
