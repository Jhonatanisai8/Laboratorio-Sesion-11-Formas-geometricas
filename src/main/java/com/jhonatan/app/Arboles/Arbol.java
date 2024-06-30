package com.jhonatan.app.Arboles;

import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class Arbol {

    public Nodo cabeza = null;
    public int TAM;
    public LinkedList lineas = new LinkedList();
    public LinkedList circulos = new LinkedList();

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int getTAM() {
        return TAM;
    }

    public void setTAM(int TAM) {
        this.TAM = TAM;
    }

    public LinkedList getLineas() {
        return lineas;
    }

    public void setLineas(LinkedList lineas) {
        this.lineas = lineas;
    }

    public LinkedList getCirculos() {
        return circulos;
    }

    public void setCirculos(LinkedList circulos) {
        this.circulos = circulos;
    }

    //métodos
    public Nodo sacarNodo(Object con) {
        Nodo aux = null;
        for (int i = 0; i < circulos.size(); i++) {
            Circulo c = (Circulo) circulos.get(i);
            if (c.com == Integer.parseInt(String.valueOf(con))) {
                aux = c.nodo;
            }
        }
        return aux;
    }
    
}
