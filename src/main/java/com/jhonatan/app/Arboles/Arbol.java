package com.jhonatan.app.Arboles;

import java.awt.Color;
import java.awt.Graphics;
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
    
    public void borrar(Nodo padre, Nodo eli) {
        System.out.println("Padre: " + padre.getValor());
        System.out.println("Elim: " + eli.getValor());
        if (padre != null) {
            if (padre.getDere() != null) {
                System.out.println("Me voy por la der -->");
                if (padre.getDere().comparar(eli) == 0) {
                    padre.setDere(null);
                    System.out.println("Se ah eliminado correctamente");
                } else {
                    borrar(padre.getDere(), eli);
                }
            }
            
            if (padre.getIzq() != null) {
                System.out.println("Me voy para la izq <--");
                if (padre.getIzq().comparar(eli) == 0) {
                    padre.setIzq(null);
                    System.out.println("Se elimino correctamente");
                } else {
                    borrar(padre.getIzq(), eli);
                }
            }
        }
    }
    
    public void elementoMasAlto(int tipo, Nodo act, Nodo cam) {
        if (tipo == 1) {
            if (act.getIzq() != null) {
                elementoMasAlto(1, act.getIzq(), cam);
            } else {
                System.out.println("Act: " + act.getValor());
                System.out.println("Cam: " + cam.getValor());
                System.out.println("Se encontro se intercambia info");
                Object ele = act.getValor();
                act.setValor(cam.getValor());
                cam.setValor(ele);
                System.out.println("Act: " + act.getValor());
                System.out.println("Cam: " + cam.getValor());
            }
        } else {
            if (act.getDere() != null) {
                elementoMasAlto(2, act.getDere(), cam);
            } else {
                System.out.println("Act: " + act.getValor());
                System.out.println("Cam: " + cam.getValor());
                System.out.println("Se encontro se intercambia info");
                Object ele = act.getValor();
                act.setValor(cam.getValor());
                cam.setValor(ele);
                System.out.println("Act: " + act.getValor());
                System.out.println("Cam: " + cam.getValor());
            }
        }
    }
    
    public boolean buscar(Nodo val, Nodo a) {
        if (a.comparar(val) == 0) {
            return true;
        }
        if (a.comparar(val) == -1) {
            return buscar(val, a.getDere());
        } else if (a.comparar(val) == 1) {
            return buscar(val, a.getIzq());
        } else {
            return false;
        }
    }
    
    public void colorearBuscado(String val) {
        for (int i = 0; i < circulos.size(); i++) {
            Circulo c = (Circulo) circulos.get(i);
            if (c.com == Integer.parseInt(val)) {
                c.relleno = Color.BLUE;
            }
        }
    }
    
    public void mensaje(String s) {
        System.out.println("Mensaje del  sistema: " + s);
    }
    
    public boolean seBusca(Object val) {
        Nodo aux = new Nodo(val);
        if (buscar(aux, cabeza) == true) {
            mensaje("Se encontro");
            return true;
        } else {
            mensaje("No se halla");
            return false;
        }
    }
    
    int TAM2 = 30;
    
    public void imprimirArbol(Nodo a, int x, int y, int v) {
        if (a == null) {
            return;
        } else {
            Circulo c = new Circulo(a.getValor(), x, y);
            c.nodo = a;
            circulos.add(c);
            if (a.getDere() != null) {
                TAM = 25 * v;
                Linea aux = new Linea(x, y, x + TAM, y + TAM2);
                lineas.add(aux);
                imprimirArbol(a.getDere(), x + TAM, y + TAM2, v - 1);
            }
            
            if (a.getIzq() != null) {
                TAM = 25 * v;
                Linea aux = new Linea(x, y, x - TAM, y + TAM2);
                lineas.add(aux);
                imprimirArbol(a.getIzq(), x - TAM, y + TAM2, v - 1);
            }
        }
    }
    
    public int numGeneraciones(Nodo a, int n) {
        if (a == null) {
            return n;
        } else {
            int n1 = numGeneraciones(a.getIzq(), n + 1);
            int nd = numGeneraciones(a.getDere(), n + 1);
            if (n1 > nd) {
                return n1;
            } else {
                return nd;
            }
        }
    }
    
    public void imprimir(int x, int y) {
        lineas = new LinkedList();
        circulos = new LinkedList();
        imprimirArbol(cabeza, x, y, numGeneraciones(cabeza, 0));
    }
    
}
