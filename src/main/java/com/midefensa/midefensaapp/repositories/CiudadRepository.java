package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    boolean existsByCiudadIdAndEstado(Integer ciudadId, Boolean estado);
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndEstado(String nombre, boolean estado);
    Ciudad findByNombre(String nombre);
    List<Ciudad> findAllByEstado(Boolean estado);
    List<Ciudad> findAllByDepartamento_DepartamentoId(Integer departamentoId);
}
