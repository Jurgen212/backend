package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class CiudadDTO {
    private Integer ciudadId;
    private Integer departamentoId;
    private String nombre;
    private boolean estado;
}
