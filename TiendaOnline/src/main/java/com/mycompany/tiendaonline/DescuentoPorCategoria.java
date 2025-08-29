package com.mycompany.tiendaonline;

public class DescuentoPorCategoria extends Decorator {
    private final String categoria;
    private final double porcentaje; // Ejemplo: 0.10 para 10%

    public DescuentoPorCategoria(Component componente, String categoria, double porcentaje) {
        super(componente);
        this.categoria = categoria;
        this.porcentaje = porcentaje;
    }

    @Override
    public int aplicarDescuento() {
        if (componente.getCategoria().equalsIgnoreCase(categoria)) {
            return (int) Math.round(componente.getPrecio() * (1 - porcentaje));
        }
        return componente.aplicarDescuento();
    }
}