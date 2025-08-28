
package com.mycompany.tiendaonline;

import java.util.List;

public class AgregarProductoComando implements Command {
    private final Component producto;
    private final List<Component> carrito;

    public AgregarProductoComando(Component producto, List<Component> carrito) {
        this.producto = producto;
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {
        carrito.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }
}