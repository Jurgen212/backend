package com.midefensa.midefensaapp.utility.enums;

public enum TipoDocumentoEnum {
    CEDULA_CIUDADANIA("Cédula de ciudadanía"),
    CEDULA_EXTRANJERIA("Cédula de extranjería"),
    TARJETA_IDENTIDAD("Tarjeta de identidad"),
    PASAPORTE("Pasaporte"),
    REGISTRO_CIVIL("Registro civil"),
    NUIP("NUIP");

    private String descripcion;

    TipoDocumentoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static boolean esValidoTipoDocumento(String descripcion) {
        for (TipoDocumentoEnum tipoDocumentoEnum : TipoDocumentoEnum.values()) {
            if (tipoDocumentoEnum.getDescripcion().equals(descripcion)) {
                return true;
            }
        }

        return false;
    }
}
