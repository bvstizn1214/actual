package com.mycompany.tiendaonline.view;

import com.mycompany.tiendaonline.decorator.Component;

public class DescuentosView {
    public void mostrarDescuento(Component producto) {
        System.out.printf("Producto: %s | Descuento aplicado: $%d\n", producto.getNombre(), producto.aplicarDescuento());
    }
}