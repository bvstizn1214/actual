package com.mycompany.tiendaonline.decorator;

import com.mycompany.tiendaonline.decorator.Decorator;
import com.mycompany.tiendaonline.decorator.Component;

public class Descuento15 extends Decorator {
    public Descuento15(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int) Math.round(componente.getPrecio() * 0.85);
    }
}