package com.mycompany.tiendaonline;

public abstract class Decorator implements Component {
    protected final Component componente;

    public Decorator(Component componente) {
        this.componente = componente;
    }

    @Override
    public int getPrecio() {
        return componente.getPrecio();
    }

    @Override
    public String getNombre() {
        return componente.getNombre();
    }
}