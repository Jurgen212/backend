package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    boolean existsByNoDocumento(String noDocumento);
    boolean existsByPersonaIdAndEstado(Integer personaId, boolean estado);
    boolean existsByNoDocumentoAndEstado(String noDocumento, boolean estado);
    Persona findByNoDocumento(String noDocumento);
    List<Persona> findAllByEstado(boolean estado);
}
