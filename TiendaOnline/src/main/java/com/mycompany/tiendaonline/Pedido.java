package com.mycompany.tiendaonline;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Component> productos = new ArrayList<>();
    private Usuario usuario;

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarProducto(Component producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Component producto) {
        productos.remove(producto);
    }

    public List<Component> getProductos() {
        return productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}