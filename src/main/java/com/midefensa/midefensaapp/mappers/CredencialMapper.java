package com.midefensa.midefensaapp.mappers;

import com.midefensa.midefensaapp.domain.Credencial;
import com.midefensa.midefensaapp.dto.CredencialDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CredencialMapper {
    public static CredencialDTO domainToDTO(Credencial credencial) {
        return CredencialDTO.builder()
                .credencialId(credencial.getCredencialId())
                .personaId(credencial.getPersona() != null ? credencial.getPersona().getPersonaId() : null)
                .rolUsuario(credencial.getRolUsuario())
                .correo(credencial.getCorreo())
                .contrasena(credencial.getContrasena())
                .estado(credencial.isEstado())
                .build();
    }

    public static List<CredencialDTO> domainToDTOList(List<Credencial> credenciales) {
        return credenciales.stream().map(CredencialMapper::domainToDTO).collect(Collectors.toList());
    }

    public static Credencial dtoToDomain(CredencialDTO credencialDTO) {
        return Credencial.builder()
                .credencialId(credencialDTO.getCredencialId())
                .rolUsuario(credencialDTO.getRolUsuario())
                .correo(credencialDTO.getCorreo())
                .contrasena(credencialDTO.getContrasena())
                .estado(credencialDTO.isEstado())
                .build();
    }

    public static List<Credencial> dtoToDomainList(List<CredencialDTO> credencialesDTO) {
        return credencialesDTO.stream().map(CredencialMapper::dtoToDomain).collect(Collectors.toList());
    }
}
