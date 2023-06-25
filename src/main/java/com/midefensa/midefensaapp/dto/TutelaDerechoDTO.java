package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TutelaDerechoDTO {
    private Integer tutelaDerechoId;
    private Integer tutelaId;
    private Integer derechoId;
    private boolean estado;
}
