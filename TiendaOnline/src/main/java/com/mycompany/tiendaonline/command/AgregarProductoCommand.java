package com.mycompany.tiendaonline.command;

import com.mycompany.tiendaonline.decorator.Component;
import com.mycompany.tiendaonline.model.Pedido;

public class AgregarProductoCommand implements Command {
    private Pedido pedido;
    private Component producto;

    public AgregarProductoCommand(Pedido pedido, Component producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.agregarProducto(producto);
    }
}