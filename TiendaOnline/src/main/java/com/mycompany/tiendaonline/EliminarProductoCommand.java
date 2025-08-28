package com.mycompany.tiendaonline;

public class EliminarProductoCommand implements Command {
    private Pedido pedido;
    private Component producto;

    public EliminarProductoCommand(Pedido pedido, Component producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.eliminarProducto(producto);
    }
}