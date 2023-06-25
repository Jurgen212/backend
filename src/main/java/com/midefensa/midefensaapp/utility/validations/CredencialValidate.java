package com.midefensa.midefensaapp.utility.validations;

public class CredencialValidate {
    public final static String CREDENCIAL_NO_NULA = "La credencial no puede ser nula";
    public final static String CREDENCIAL_NO_EXISTE = "La credencial con id %s no existe";
    public final static String CREDENCIAL_ELIMINADA = "La credencial con correo %s fue eliminada";
    public final static String PERSONA_NO_NULO = "El id de la persona no puede ser nulo";
    public final static String PERSONA_NO_EXISTE = "La persona con id %s no existe";
    public final static String ROLUSUARIO_NO_NULO = "El id deL rol de usuario no puede ser nulo";
    public final static String ROLUSUARIO_NO_EXISTE = "El rol de usuario con id %s no existe";
    public final static String CORREO_NO_NULO_VACIO = "El correo de la credencial no puede ser nulo o vacío";
    public final static String CORREO_NO_EXISTE = "La credencial con correo %s no existe";
    public final static String CORREO_YA_EXISTE = "La credencial con correo %s ya existe";
    public final static String CORREO_REGEX_MENSAJE = "El correo de la credencial no cumple con el formato";
    public final static String CORREO_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public final static String CONTRASENA_NO_NULO_VACIO = "La contraseña de la credencial no puede ser nula o vacía";
    public final static String CONTRASENA_REGEX_MENSAJE = "La contraseña de la credencial debe tener al menos 8 caracteres, una letra y un número";
    public final static String CONTRASENA_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
    public final static String CORREO_CONTRASENA_NO_EXISTE = "Correo y/o contraseña incorrectos";
}
