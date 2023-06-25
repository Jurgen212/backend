package com.midefensa.midefensaapp.security.auth;

import com.midefensa.midefensaapp.utility.enums.RolUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Integer personaId;
    private String correo;
    private String contrasena;
    private RolUsuarioEnum rolUsuario;
    private boolean estado;
}
