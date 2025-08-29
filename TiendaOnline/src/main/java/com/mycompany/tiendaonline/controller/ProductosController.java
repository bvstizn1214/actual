package com.mycompany.tiendaonline.controller;
import com.mycompany.tiendaonline.view.ProductosView;
import com.mycompany.tiendaonline.decorator.Component;
import java.util.List;

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