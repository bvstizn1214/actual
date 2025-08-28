package com.mycompany.tiendaonline;

/**
 * Modelo que representa un usuario de la tienda.
 */
public class Usuario {
    private String nombre;
    private String correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}