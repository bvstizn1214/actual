package com.mycompany.tiendaonline;


public class DescuentoPorCategoria extends Decorator {
    private String categoria;
    private double porcentaje;

    public DescuentoPorCategoria(Component componente, String categoria, double porcentaje) {
        super(componente);
        this.categoria = categoria;
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarDescuento() {
        if (componente instanceof Producto) {
            Producto producto = (Producto) componente;
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                return producto.getPrecio() * (1 - porcentaje);
            }
        }
        return super.aplicarDescuento();
    }
}