package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Integer> {
    boolean existsByCredencialIdAndEstado(Integer credencialId, Boolean estado);
    boolean existsByCorreo(String correo);
    boolean existsByCorreoAndEstado(String correo, boolean estado);
    Credencial findByCorreo(String correo);
    Optional<Credencial> findOneByCorreo(String correo);
    List<Credencial> findAllByEstado(boolean estado);
}
