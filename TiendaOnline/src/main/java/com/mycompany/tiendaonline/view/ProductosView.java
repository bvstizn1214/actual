package com.mycompany.tiendaonline.view;
import com.mycompany.tiendaonline.decorator.Component;
import java.util.List;

public class ProductosView {
    public void mostrarProductos(List<Component> productos) {
        System.out.println("\nProductos disponibles:");
        int idx = 1;
        for (Component p : productos) {
            System.out.printf("%d. %s - $%d CLP (Descuento: $%d)\n", idx++, p.getNombre(), p.getPrecio(), p.aplicarDescuento());
        }
    }
}