
package com.mycompany.tiendaonline.decorator;

import com.mycompany.tiendaonline.decorator.Decorator;
import com.mycompany.tiendaonline.decorator.Component;

public class Descuento20 extends Decorator {
    public Descuento20(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int)Math.round(componente.getPrecio() * 0.8);
    }
}