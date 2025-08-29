package com.mycompany.tiendaonline.decorator;

import com.mycompany.tiendaonline.decorator.Decorator;
import com.mycompany.tiendaonline.decorator.Component;

public class Descuento10 extends Decorator {
    public Descuento10(Component componente) {
        super(componente);
    }

    @Override
    public int aplicarDescuento() {
        return (int) Math.round(componente.getPrecio() * 0.90);
    }
}