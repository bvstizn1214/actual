package com.mycompany.tiendaonline;

import java.util.List;

/**
 * Vista para mostrar los productos disponibles.
 */
public class ProductosView {
    public void mostrarProductos(List<Component> productos) {
        System.out.println("Productos disponibles:");
        for (Component p : productos) {
            System.out.printf("Nombre: %s | Precio: $%d CLP\n", p.getNombre(), p.getPrecio());
        }
    }
}