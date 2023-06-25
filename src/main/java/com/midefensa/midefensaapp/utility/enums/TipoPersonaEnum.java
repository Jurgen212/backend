package com.midefensa.midefensaapp.utility.enums;

public enum TipoPersonaEnum {
    NATURAL("Natural"),
    JURIDICA("Jurídica");

    private String descripcion;

    TipoPersonaEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static boolean esValidoTipoPersona(String descripcion) {
        for (TipoPersonaEnum tipoPersonaEnum : TipoPersonaEnum.values()) {
            if (tipoPersonaEnum.getDescripcion().equals(descripcion)) {
                return true;
            }
        }

        return false;
    }
}
