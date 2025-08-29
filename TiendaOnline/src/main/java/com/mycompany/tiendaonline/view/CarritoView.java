package com.mycompany.tiendaonline.view;

import com.mycompany.tiendaonline.decorator.Component;
import com.mycompany.tiendaonline.model.Pedido;

public class CarritoView {
    public void mostrarCarrito(Pedido pedido) {
        System.out.println("\nCarrito:");
        int idx = 1;
        int total = 0;
        for (Component c : pedido.getProductos()) {
            int precioFinal = c.aplicarDescuento();
            System.out.printf("%d. %s - Original: $%d | Final: $%d\n", idx++, c.getNombre(), c.getPrecio(), precioFinal);
            total += precioFinal;
        }
        System.out.printf("Total a pagar: $%d\n", total);
    }
}