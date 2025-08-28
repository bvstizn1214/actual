package com.mycompany.tiendaonline;

public interface Component {
    int aplicarDescuento(); // Retorna el precio final en CLP, sin decimales
    String getNombre();
    int getPrecio();
}