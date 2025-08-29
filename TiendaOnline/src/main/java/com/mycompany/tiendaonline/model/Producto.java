package com.mycompany.tiendaonline.model;

import com.mycompany.tiendaonline.decorator.Component;

public class Producto implements Component {
    private String nombre;
    private int precio;
    private String categoria;

    public Producto(String nombre, int precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public int aplicarDescuento() {
        return precio;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }
}