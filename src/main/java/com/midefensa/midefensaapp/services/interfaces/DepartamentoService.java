package com.midefensa.midefensaapp.services.interfaces;

import com.midefensa.midefensaapp.dto.DepartamentoDTO;
import com.midefensa.midefensaapp.exceptions.DepartamentoException;

import java.util.List;

public interface DepartamentoService {
    DepartamentoDTO guardarDepartamento(DepartamentoDTO departamentoDTO) throws DepartamentoException;
    DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamentoDTO) throws DepartamentoException;
    List<DepartamentoDTO> obtenerTodosLosDepartamentos();
    List<DepartamentoDTO> obtenerTodosLosDepartamentosActivos();
    DepartamentoDTO buscarDepartamentoPorId(Integer departamentoId) throws DepartamentoException;
    DepartamentoDTO buscarDepartamentoPorIdActivo(Integer departamentoId) throws DepartamentoException;
    DepartamentoDTO buscarDepartamentoPorNombre(String nombre) throws DepartamentoException;
    DepartamentoDTO buscarDepartamentoPorNombreActivo(String nombre) throws DepartamentoException;
    DepartamentoDTO inactivarDepartamento(Integer departamentoId) throws DepartamentoException;
    DepartamentoDTO activarDepartamento(Integer departamentoId) throws DepartamentoException;
    String eliminarDepartamento(Integer departamentoId) throws DepartamentoException;
}
