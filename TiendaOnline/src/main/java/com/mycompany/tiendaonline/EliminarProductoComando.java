package com.mycompany.tiendaonline;

import java.util.List;

public class EliminarProductoComando implements Command {
    private Producto producto;
    private List<Producto> carrito;

    public EliminarProductoComando(Producto producto, List<Producto> carrito) {
        this.producto = producto;
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {
        carrito.remove(producto);
        System.out.println("Producto eliminado: " + producto.getNombre());
    }
}