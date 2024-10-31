/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpFinal;

/**
 *
 * @author agusv
 */
public class NodoEstacionAVL {

    private Comparable clave;
    private Object datosEstacion;
    private NodoEstacionAVL izquierdo;
    private NodoEstacionAVL derecho;
    private int altura = 0;

    public NodoEstacionAVL(Comparable n, Object infoEstacion) {
        this.clave = n;
        this.datosEstacion = infoEstacion;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Comparable getClave() {
        return this.clave;
    }

    public Estacion getDatos() {
        return (Estacion) this.datosEstacion;
    }

    public NodoEstacionAVL getIzquierdo() {
        return this.izquierdo;
    }

    public NodoEstacionAVL getDerecho() {
        return this.derecho;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setClave(Comparable n) {
        this.clave = n;
    }

    public void setDato(Estacion info) {
        this.datosEstacion = info;
    }

    public void setIzquierdo(NodoEstacionAVL nodo) {
        this.izquierdo = nodo;
    }

    public void setDerecho(NodoEstacionAVL nodo) {
        this.derecho = nodo;
    }

    public void recalcularAltura() {
        int altIz, altDe;
        if (this.getIzquierdo() != null) {
            altIz = this.getIzquierdo().getAltura() + 1;
        } else {
            altIz = -1;
        }
        if (this.getDerecho() != null) {
            altDe = this.getDerecho().getAltura() + 1;
        } else {
            altDe = -1;
        }
        if (altIz == -1 && altDe == -1) {
            this.altura = 0;
        } else if (altIz >= altDe) {
            this.altura = altIz;
        } else {
            this.altura = altDe;
        }
    }

    public int obtenerBalance() {
        int balance, altIz, altDe;
        if (this.getIzquierdo() != null) {
            altIz = this.getIzquierdo().getAltura();
        } else {
            altIz = -1;
        }
        if (this.getDerecho() != null) {
            altDe = this.getDerecho().getAltura();
        } else {
            altDe = -1;
        }
        balance = altIz - altDe;
        return balance;
    }
}
