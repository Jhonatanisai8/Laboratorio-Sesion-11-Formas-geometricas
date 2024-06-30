package com.jhonatan.app.Arboles;

import java.awt.Color;

/**
 *
 * @author Jhonatan
 */
public class Circulo {

    public Color borde = Color.BLACK;
    public Color relleno = Color.BLACK;
    public int tam = 0;
    public int com, x, y;
    public Nodo nodo;

    public Circulo() {
    }

    public Circulo(Object com, int x, int y) {
        this.com = Integer.parseInt(String.valueOf(com));
        this.x = x;
        this.y = y;
    }

}
