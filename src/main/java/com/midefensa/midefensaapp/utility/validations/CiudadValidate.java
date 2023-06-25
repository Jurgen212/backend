package com.midefensa.midefensaapp.utility.validations;

public class CiudadValidate {
    public final static String CIUDAD_NO_NULA = "La ciudad no puede ser nula";
    public final static String CIUDAD_NO_EXISTE = "La ciudad con id %s no existe";
    public final static String CIUDAD_ELIMINADA = "La ciudad con id %s fue eliminada";
    public final static String DEPARTAMENTO_NO_NULO = "El id del departamento no puede ser nulo";
    public final static String DEPARTAMENTO_NO_EXISTE = "El departamento con id %s no existe";
    public final static String NOMBRE_NO_NULO_VACIO = "El nombre de la ciudad no puede ser nulo o vacío";
    public final static String NOMBRE_NO_EXISTE = "La ciudad con nombre %s no existe";
    public final static String NOMBRE_YA_EXISTE = "La ciudad con nombre %s ya existe";
    public final static String NOMBRE_REGEX_MENSAJE = "El nombre de la ciudad solo puede contener letras";
    public final static String NOMBRE_REGEX = "^[\\p{L}\\s'-]+$";
}
