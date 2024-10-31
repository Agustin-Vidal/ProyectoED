/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpFinal;

/**
 *
 * @author agustinvidal
 */
public class Lista {

    private Nodo cabecera;
    private int longitud = 0;

    public Lista() {
        cabecera = null;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nodoNuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nodoNuevo);
            }
            this.longitud++;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito;
        if (pos < 1 || pos > this.longitud()) {
            exito = false;
        } else {
            if (pos == 1) {
                cabecera = this.cabecera.getEnlace();
                exito = true;
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                exito = true;
            }
            this.longitud--;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        // La posicion debe ser valida
        Nodo aux = this.cabecera;
        int i = 1;
        while (i < pos) {
            aux = aux.getEnlace();
            i++;
        }
        return aux.getElem();
    }

    public int localizar(Object elem) {
        int i = 1, posBus = -1;
        Nodo aux = this.cabecera;
        while (i <= this.longitud() && i != posBus) {
            if (aux.getElem().equals(elem)) {
                posBus = i;
            } else {
                aux = aux.getEnlace();
            }
            i++;
        }
        return posBus;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public Lista clonar() {
        Lista clon = new Lista();
        Nodo aux, aux2, nuevo;
        aux = this.cabecera;
        if (aux != null) {
            clon.cabecera = new Nodo(this.cabecera.getElem());
            aux2 = clon.cabecera;
            aux = aux.getEnlace();
            while (aux != null) {
                nuevo = new Nodo(aux.getElem());
                aux2.setEnlace(nuevo);
                aux2 = aux2.getEnlace();
                aux = aux.getEnlace();
            }
        }
        clon.longitud = this.longitud;
        return clon;
    }

    public int longitud() {
        return this.longitud;
    }

    public String toString() {
        String s = "";
        Nodo aux;
        if (this.esVacia()) {
            s = "Lista Vacia";
        } else {
            s += "[";
            aux = this.cabecera;
            while (aux != null) {
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ", ";
                }
            }
            s += "]";
        }
        return s;
    }
}
