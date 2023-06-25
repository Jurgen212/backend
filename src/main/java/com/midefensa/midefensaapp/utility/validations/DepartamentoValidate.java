package com.midefensa.midefensaapp.utility.validations;

public class DepartamentoValidate {
    public final static String DEPARTAMENTO_NO_NULO = "El departamento no puede ser nulo";
    public final static String DEPARTAMENTO_NO_EXISTE = "El departamento con id %s no existe";
    public final static String DEPARTAMENTO_ELIMINADO = "El departamento con id %s fue eliminado";
    public final static String NOMBRE_NO_NULO_VACIO = "El nombre del departamento no puede ser nulo o vacío";
    public final static String NOMBRE_NO_EXISTE = "El departamento con nombre %s no existe";
    public final static String NOMBRE_YA_EXISTE = "El departamento con nombre %s ya existe";
    public final static String NOMBRE_REGEX_MENSAJE = "El nombre del departamento solo puede contener letras";
    public final static String NOMBRE_REGEX = "^[\\p{L}\\s'-]+$";
}
