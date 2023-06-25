package com.midefensa.midefensaapp.utility.validations;

public class PersonaValidate {
    public final static String PERSONA_NO_NULA = "La persona no puede ser nula";
    public final static String PERSONA_NO_EXISTE = "La persona con id %s no existe";
    public final static String PERSONA_NO_EXISTE_NODOCUMENTO = "La persona con número de documento %s no existe";
    public final static String PERSONA_ELIMINADA = "La persona con número de documento %s fue eliminada";
    public final static String TIPODOCUMENTO_NO_NULO = "El id del tipo de documento no puede ser nulo";
    public final static String TIPODOCUMENTO_NO_EXISTE = "El tipo de documento con id %s no existe";
    public final static String CIUDAD_NO_NULA = "El id de la ciudad no puede ser nulo";
    public final static String CIUDAD_NO_EXISTE = "La ciudad con id %s no existe";
    public final static String NOMBRE_NO_NULO_VACIO = "El nombre no puede ser nulo o vacío";
    public final static String NOMBRE_REGEX_MENSAJE = "El nombre solo puede contener letras";
    public final static String NOMBRE_REGEX = "^[\\p{L}\\s'-]+$";
    public final static String APELLIDO_NO_NULO_VACIO = "El apellido no puede ser nulo o vacío";
    public final static String APELLIDO_REGEX_MENSAJE = "El apellido solo puede contener letras";
    public final static String APELLIDO_REGEX = "^[\\p{L}\\s'-]+$";
    public final static String NODOCUMENTO_NO_NULO_VACIO = "El número de documento no puede ser nulo o vacío";
    public final static String NODOCUMENTO_REGEX_MENSAJE = "El número de documento solo puede contener números";
    public final static String NODOCUMENTO_YA_EXISTE = "El número de documento %s ya existe";
    public final static String NODOCUMENTO_REGEX = "^[0-9]*$";
    public final static String TELEFONOFIJO_NO_NULO_VACIO = "El teléfono fijo no puede ser nulo o vacío";
    public final static String TELEFONOFIJO_REGEX_MENSAJE = "El teléfono fijo solo puede contener números";
    public final static String TELEFONOFIJO_REGEX = "^[0-9]*$";
    public final static String TELEFONOCELULAR_NO_NULO_VACIO = "El teléfono celular no puede ser nulo o vacío";
    public final static String TELEFONOCELULAR_REGEX_MENSAJE = "El teléfono celular solo puede contener números";
    public final static String TELEFONOCELULAR_REGEX = "^[0-9]*$";
    public final static String TIPOPERSONA_NO_NULO_VACIO = "El tipo de persona no puede ser nulo o vacío";
    public final static String TIPOPERSONA_NO_VALIDA = "La descripción del tipo de persona es inválida";
}
