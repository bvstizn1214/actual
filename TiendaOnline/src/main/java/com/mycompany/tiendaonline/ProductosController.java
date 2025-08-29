package com.mycompany.tiendaonline;

import java.util.List;

/**
 * Controlador para productos.
 */
public class ProductosController {
    private List<Component> productos;
    private ProductosView vista;

    public ProductosController(List<Component> productos, ProductosView vista) {
        this.productos = productos;
        this.vista = vista;
    }

    public void mostrarProductos() {
        vista.mostrarProductos(productos);
    }
}