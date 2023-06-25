package com.midefensa.midefensaapp.services.interfaces;

import com.midefensa.midefensaapp.dto.CredencialDTO;
import com.midefensa.midefensaapp.exceptions.CredencialException;

import java.util.List;

public interface CredencialService {
    CredencialDTO guardarCredencial(CredencialDTO credencialDTO) throws CredencialException;
    CredencialDTO actualizarCredencial(CredencialDTO credencialDTO) throws CredencialException;
    List<CredencialDTO> obtenerTodasLasCredenciales();
    List<CredencialDTO> obtenerTodasLasCredencialesActivas();
    CredencialDTO buscarCredencialPorId(Integer credencialId) throws CredencialException;
    CredencialDTO buscarCredencialPorIdActiva(Integer credencialId) throws CredencialException;
    CredencialDTO buscarCredencialPorCorreo(String correo) throws CredencialException;
    CredencialDTO buscarCredencialPorCorreoActiva(String correo) throws CredencialException;
    CredencialDTO inactivarCredencial(String correo) throws CredencialException;
    CredencialDTO activarCredencial(String correo) throws CredencialException;
    String eliminarCredencial(String correo) throws CredencialException;
    void validarCredencial(CredencialDTO credencialDTO, boolean esGuardar) throws CredencialException;
}
