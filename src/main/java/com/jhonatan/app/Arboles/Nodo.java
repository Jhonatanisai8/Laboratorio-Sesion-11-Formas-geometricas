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

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDere() {
        return dere;
    }

    public void setDere(Nodo dere) {
        this.dere = dere;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

  
}
