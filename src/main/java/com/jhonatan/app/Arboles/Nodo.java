package com.jhonatan.app.Arboles;

/**
 *
 * @author Jhonatan
 */
public class Nodo {

    private Nodo padre = null;
    private Nodo izq = null, dere = null;
    private Object valor;

    //esto es solo algo que uso para podernlos imprimir graficamente
    private int nivel;

    public Nodo(Nodo padre, Object valor) {
        this.padre = padre;
        this.valor = valor;
    }

    public Nodo(Object valor) {
        this.valor = valor;
    }
}
