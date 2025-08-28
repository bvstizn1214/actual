package com.mycompany.tiendaonline;

public class Producto implements Component {
    private final String nombre;
    private final int precio;
    private final String categoria;

    public Producto(String nombre, int precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public String getCategoria() {
    return this.categoria;
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