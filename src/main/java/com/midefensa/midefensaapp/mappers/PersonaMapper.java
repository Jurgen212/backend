package com.midefensa.midefensaapp.mappers;

import com.midefensa.midefensaapp.domain.Persona;
import com.midefensa.midefensaapp.dto.PersonaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaMapper {
    public static PersonaDTO domainToDto(Persona persona) {
        return PersonaDTO.builder()
                .personaId(persona.getPersonaId())
                .tipoDocumentoId(persona.getTipoDocumento() != null ? persona.getTipoDocumento().getTipoDocumentoId() : null)
                .ciudadId(persona.getCiudad() != null ? persona.getCiudad().getCiudadId() : null)
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .noDocumento(persona.getNoDocumento())
                .telefonoFijo(persona.getTelefonoFijo())
                .telefonoCelular(persona.getTelefonoCelular())
                .tipoPersona(persona.getTipoPersona())
                .estado(persona.isEstado())
                .build();
    }

    public static List<PersonaDTO> domainToDtoList(List<Persona> personas) {
        return personas.stream().map(PersonaMapper::domainToDto).collect(Collectors.toList());
    }

    public static Persona dtoToDomain(PersonaDTO personaDTO) {
        return Persona.builder()
                .personaId(personaDTO.getPersonaId())
                .nombre(personaDTO.getNombre())
                .apellido(personaDTO.getApellido())
                .noDocumento(personaDTO.getNoDocumento())
                .telefonoFijo(personaDTO.getTelefonoFijo())
                .telefonoCelular(personaDTO.getTelefonoCelular())
                .tipoPersona(personaDTO.getTipoPersona())
                .estado(personaDTO.isEstado())
                .build();
    }

    public static List<Persona> dtoToDomainList(List<PersonaDTO> personasDTO) {
        return personasDTO.stream().map(PersonaMapper::dtoToDomain).collect(Collectors.toList());
    }
}
