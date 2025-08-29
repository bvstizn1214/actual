package com.mycompany.tiendaonline.controller;

import com.mycompany.tiendaonline.view.CarritoView;
import com.mycompany.tiendaonline.model.Pedido;

public class CarritoController {
    private Pedido pedido;
    private CarritoView vista;

    public CarritoController(Pedido pedido, CarritoView vista) {
        this.pedido = pedido;
        this.vista = vista;
    }
    public void mostrarCarrito() {
        vista.mostrarCarrito(pedido);
    }
}