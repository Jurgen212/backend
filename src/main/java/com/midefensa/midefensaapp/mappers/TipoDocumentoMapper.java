package com.midefensa.midefensaapp.mappers;

import com.midefensa.midefensaapp.domain.TipoDocumento;
import com.midefensa.midefensaapp.dto.TipoDocumentoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TipoDocumentoMapper {
    public static TipoDocumentoDTO domainToDto(TipoDocumento tipoDocumento) {
        return TipoDocumentoDTO.builder()
                .tipoDocumentoId(tipoDocumento.getTipoDocumentoId())
                .descripcion(tipoDocumento.getDescripcion())
                .estado(tipoDocumento.isEstado())
                .build();
    }

    public static List<TipoDocumentoDTO> domainToDtoList(List<TipoDocumento> tipoDocumentos) {
        return tipoDocumentos.stream().map(TipoDocumentoMapper::domainToDto).collect(Collectors.toList());
    }

    public static TipoDocumento dtoToDomain(TipoDocumentoDTO tipoDocumentoDTO) {
        return TipoDocumento.builder()
                .tipoDocumentoId(tipoDocumentoDTO.getTipoDocumentoId())
                .descripcion(tipoDocumentoDTO.getDescripcion())
                .estado(tipoDocumentoDTO.isEstado())
                .build();
    }

    public static List<TipoDocumento> dtoToDomainList(List<TipoDocumentoDTO> tipoDocumentosDTO) {
        return tipoDocumentosDTO.stream().map(TipoDocumentoMapper::dtoToDomain).collect(Collectors.toList());
    }
}
