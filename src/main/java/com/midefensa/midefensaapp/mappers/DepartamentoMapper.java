package com.midefensa.midefensaapp.mappers;

import com.midefensa.midefensaapp.domain.Departamento;
import com.midefensa.midefensaapp.dto.DepartamentoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoMapper {
    public static DepartamentoDTO domainToDto(Departamento departamento) {
        return DepartamentoDTO.builder()
                .departamentoId(departamento.getDepartamentoId())
                .nombre(departamento.getNombre())
                .estado(departamento.isEstado())
                .build();
    }

    public static List<DepartamentoDTO> domainToDtoList(List<Departamento> departamentos) {
        return departamentos.stream().map(DepartamentoMapper::domainToDto).collect(Collectors.toList());
    }

    public static Departamento dtoToDomain(DepartamentoDTO departamentoDTO) {
        return Departamento.builder()
                .departamentoId(departamentoDTO.getDepartamentoId())
                .nombre(departamentoDTO.getNombre())
                .estado(departamentoDTO.isEstado())
                .build();
    }

    public static List<Departamento> dtoToDomainList(List<DepartamentoDTO> departamentosDTO) {
        return departamentosDTO.stream().map(DepartamentoMapper::dtoToDomain).collect(Collectors.toList());
    }
}
