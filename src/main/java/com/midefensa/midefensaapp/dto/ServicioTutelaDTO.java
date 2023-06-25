package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ServicioTutelaDTO {
    private Integer servicioTutelaId;
    private Integer tutelaId;
    private Integer credencialId;
    private boolean estado;
}
