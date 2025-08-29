package com.mycompany.tiendaonline.decorator;

public interface Component {
    String getNombre();
    int getPrecio();
    int aplicarDescuento();
    String getCategoria();
}