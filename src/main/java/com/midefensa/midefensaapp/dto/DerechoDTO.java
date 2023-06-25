package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class DerechoDTO {
    private Integer derechoId;
    private Integer tipoDerechoId;
    private String descripcion;
    private boolean estado;
}
