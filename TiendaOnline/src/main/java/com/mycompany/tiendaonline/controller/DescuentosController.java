package com.mycompany.tiendaonline.controller;

import com.mycompany.tiendaonline.view.DescuentosView;
import com.mycompany.tiendaonline.decorator.Component;

public class DescuentosController {
    private DescuentosView vista;

    public DescuentosController(DescuentosView vista) {
        this.vista = vista;
    }
    public void mostrarDescuento(Component producto) {
        vista.mostrarDescuento(producto);
    }
}