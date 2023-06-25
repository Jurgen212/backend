package com.midefensa.midefensaapp.dto;

import com.midefensa.midefensaapp.utility.enums.RolUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class CredencialDTO {
    private Integer credencialId;
    private Integer personaId;
    private RolUsuarioEnum rolUsuario;
    private String correo;
    private String contrasena;
    private boolean estado;
}
