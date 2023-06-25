package com.midefensa.midefensaapp.services.interfaces;

import com.midefensa.midefensaapp.dto.CiudadDTO;
import com.midefensa.midefensaapp.exceptions.CiudadException;

import java.util.List;

public interface CiudadService {
    CiudadDTO guardarCiudad(CiudadDTO ciudadDTO) throws CiudadException;
    CiudadDTO actualizarCiudad(CiudadDTO ciudadDTO) throws CiudadException;
    List<CiudadDTO> obtenerTodasLasCiudades();
    List<CiudadDTO> obtenerTodasLasCiudadesActivas();
    List<CiudadDTO> obtenerTodasLasCiudadesPorDepartamentoId(Integer departamentoId) throws CiudadException;
    CiudadDTO buscarCiudadPorId(Integer ciudadId) throws CiudadException;
    CiudadDTO buscarCiudadPorIdActiva(Integer ciudadId) throws CiudadException;
    CiudadDTO buscarCiudadPorNombre(String nombre) throws CiudadException;
    CiudadDTO buscarCiudadPorNombreActiva(String nombre) throws CiudadException;
    CiudadDTO inactivarCiudad(Integer ciudadId) throws CiudadException;
    CiudadDTO activarCiudad(Integer ciudadId) throws CiudadException;
    String eliminarCiudad(Integer ciudadId) throws CiudadException;
}
