package com.mycompany.tiendaonline;

public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Aplica el descuento usando el decorador que recibe
    public int aplicarDescuento(Component producto, Decorator decorador) {
        if (decorador != null) {
            return decorador.aplicarDescuento();
        }
        return producto.getPrecio();
    }
}