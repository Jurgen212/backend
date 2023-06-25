package com.midefensa.midefensaapp.mappers;

import com.midefensa.midefensaapp.domain.Ciudad;
import com.midefensa.midefensaapp.dto.CiudadDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CiudadMapper {
    public static CiudadDTO domainToDto(Ciudad ciudad) {
        return CiudadDTO.builder()
                .ciudadId(ciudad.getCiudadId())
                .departamentoId(ciudad.getDepartamento() != null ? ciudad.getDepartamento().getDepartamentoId() : null)
                .nombre(ciudad.getNombre())
                .estado(ciudad.isEstado())
                .build();
    }

    public static List<CiudadDTO> domainToDtoList(List<Ciudad> ciudades) {
        return ciudades.stream().map(CiudadMapper::domainToDto).collect(Collectors.toList());
    }

    public static Ciudad dtoToDomain(CiudadDTO ciudadDTO) {
        return Ciudad.builder()
                .ciudadId(ciudadDTO.getCiudadId())
                .nombre(ciudadDTO.getNombre())
                .estado(ciudadDTO.isEstado())
                .build();
    }

    public static List<Ciudad> dtoToDomainList(List<CiudadDTO> ciudadesDTO) {
        return ciudadesDTO.stream().map(CiudadMapper::dtoToDomain).collect(Collectors.toList());
    }
}
