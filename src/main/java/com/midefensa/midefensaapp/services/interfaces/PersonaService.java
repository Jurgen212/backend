package com.midefensa.midefensaapp.services.interfaces;

import com.midefensa.midefensaapp.dto.PersonaDTO;
import com.midefensa.midefensaapp.exceptions.PersonaException;

import java.util.List;

public interface PersonaService {
    PersonaDTO guardarPersona(PersonaDTO personaDTO) throws PersonaException;
    PersonaDTO actualizarPersona(PersonaDTO personaDTO) throws PersonaException;
    List<PersonaDTO> obtenerTodasLasPersonas();
    List<PersonaDTO> obtenerTodasLasPersonasActivas();
    PersonaDTO buscarPersonaPorId(Integer personaId) throws PersonaException;
    PersonaDTO buscarPersonaPorIdActiva(Integer personaId) throws PersonaException;
    PersonaDTO buscarPersonaPorNoDocumento(String noDocumento) throws PersonaException;
    PersonaDTO buscarPersonaPorNoDocumentoActiva(String noDocumento) throws PersonaException;
    PersonaDTO inactivarPersona(String noDocumento) throws PersonaException;
    PersonaDTO activarPersona(String noDocumento) throws PersonaException;
    String eliminarPersona(String noDocumento) throws PersonaException;
}
