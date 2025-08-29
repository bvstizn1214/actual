package com.mycompany.tiendaonline;

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