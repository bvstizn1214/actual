package com.mycompany.tiendaonline;

/**
 * Decorador que aplica un descuento por categoría al producto.
 */
public class DescuentoPorCategoria extends Decorator {
    private final String categoria;
    private final double porcentaje; // Ejemplo: 0.10 para 10%

    /**
     * Constructor del decorador de descuento por categoría.
     * 
     * @param componente El componente a decorar.
     * @param categoria La categoría a la que se aplica el descuento.
     * @param porcentaje El porcentaje de descuento (ejemplo: 0.10 para 10%).
     */
    public DescuentoPorCategoria(Component componente, String categoria, double porcentaje) {
        super(componente);
        this.categoria = categoria;
        this.porcentaje = porcentaje;
    }

    /**
     * Aplica el descuento si la categoría coincide.
     * 
     * @return El precio con descuento si corresponde, o el precio original.
     */
    @Override
    public int aplicarDescuento() {
        if (componente instanceof Producto) {
            Producto producto = (Producto) componente;
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                return (int) Math.round(producto.getPrecio() * (1 - porcentaje));
            }
        }
        // Si no coincide la categoría, aplica el descuento del siguiente decorador (si existe)
        return componente.aplicarDescuento();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNombre() {
        return componente.getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrecio() {
        return componente.getPrecio();
    }
}