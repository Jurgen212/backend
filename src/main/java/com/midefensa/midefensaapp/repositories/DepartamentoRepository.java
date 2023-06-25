package com.midefensa.midefensaapp.repositories;

import com.midefensa.midefensaapp.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    boolean existsByDepartamentoIdAndEstado(Integer departamentoId, boolean estado);
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndEstado(String nombre, boolean estado);
    Departamento findByNombre(String nombre);
    List<Departamento> findAllByEstado(boolean estado);
}
