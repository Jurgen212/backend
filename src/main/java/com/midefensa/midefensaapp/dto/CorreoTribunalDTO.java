package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class CorreoTribunalDTO {
    private Integer correoTribunalId;
    private Integer ciudadId;
    private Integer tipoDerechoId;
    private String correo;
    private boolean estado;
}
