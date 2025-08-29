package com.mycompany.tiendaonline;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Component> productos = new ArrayList<>();

    public void agregarProducto(Component producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Component producto) {
        productos.remove(producto);
    }

    public List<Component> getProductos() {
        return productos;
    }
}