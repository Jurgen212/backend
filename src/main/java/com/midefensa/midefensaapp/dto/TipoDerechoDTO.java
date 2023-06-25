package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TipoDerechoDTO {
    private Integer tipoDerechoId;
    private String descripcion;
    private boolean estado;
}
