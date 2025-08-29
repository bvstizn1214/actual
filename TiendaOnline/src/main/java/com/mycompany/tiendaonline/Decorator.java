package com.mycompany.tiendaonline;

public abstract class Decorator implements Component {
    protected Component componente;

    public Decorator(Component componente) {
        this.componente = componente;
    }

    @Override
    public String getNombre() {
        return componente.getNombre();
    }

    @Override
    public int getPrecio() {
        return componente.getPrecio();
    }

    @Override
    public String getCategoria() {
        return componente.getCategoria();
    }
}