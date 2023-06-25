package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TipoDocumentoDTO {
    private Integer tipoDocumentoId;
    private String descripcion;
    private boolean estado;
}
