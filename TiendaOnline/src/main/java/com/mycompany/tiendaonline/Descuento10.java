package com.mycompany.tiendaonline;

public class Descuento10 extends Decorator {
    public Descuento10(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int) Math.round(componente.getPrecio() * 0.90);
    }
}