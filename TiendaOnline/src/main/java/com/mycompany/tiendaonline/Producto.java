package com.mycompany.tiendaonline;

public class Producto implements Component {
    private final String nombre;
    private final int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public int aplicarDescuento() {
        return precio; // Sin descuento por defecto
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
}