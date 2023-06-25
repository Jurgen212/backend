package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.MediaType;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TutelaDTO {
    private Integer tutelaId;
    private Integer demandantePersonaId;
    private Integer demandadoPersonaId;
    private String descripcion;
    private String necesidad;
    private MediaType pdf;
    private boolean estado;
}
