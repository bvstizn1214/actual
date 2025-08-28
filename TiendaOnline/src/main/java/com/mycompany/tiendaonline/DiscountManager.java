package com.mycompany.tiendaonline;

public class DiscountManager {
    private static DiscountManager instancia;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instancia == null) {
            instancia = new DiscountManager();
        }
        return instancia;
    }

    public int aplicarDescuento(Component producto) {
        return producto.aplicarDescuento();
    }
}