package com.midefensa.midefensaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class PersonaDTO {
    private Integer personaId;
    private Integer tipoDocumentoId;
    private Integer ciudadId;
    private String nombre;
    private String apellido;
    private String noDocumento;
    private String telefonoFijo;
    private String telefonoCelular;
    private String tipoPersona;
    private boolean estado;
}
