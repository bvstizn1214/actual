package com.mycompany.tiendaonline;

/**
 * Singleton responsable de aplicar descuentos usando Decorator.
 */
public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    /**
     * Aplica el decorador recibido al componente (producto).
     */
    public int aplicarDescuento(Component producto, Decorator decorador) {
        decorador = decorador == null ? null : decorador;
        if (decorador != null) {
            return decorador.aplicarDescuento();
        }
        return producto.getPrecio();
    }
}