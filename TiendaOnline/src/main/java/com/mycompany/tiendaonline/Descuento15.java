
package com.mycompany.tiendaonline;

public class Descuento15 extends Decorator {
    public Descuento15(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int)Math.round(componente.getPrecio() * 0.85);
    }
}