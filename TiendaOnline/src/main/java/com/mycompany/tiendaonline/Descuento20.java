
package com.mycompany.tiendaonline;

public class Descuento20 extends Decorator {
    public Descuento20(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int)Math.round(componente.getPrecio() * 0.8);
    }
}