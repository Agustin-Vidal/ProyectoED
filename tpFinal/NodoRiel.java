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
public class NodoRiel {

    private NodoEstacionGrafo estacion;
    private NodoRiel sigAdyacente;
    private int tiempo;

    public NodoRiel(NodoEstacionGrafo estacion, NodoRiel adyacente, int tiempo) {
        this.estacion = estacion;
        this.sigAdyacente = adyacente;
        this.tiempo = tiempo;
    }

    public void setEstacion(NodoEstacionGrafo estacion) {
        this.estacion = estacion;
    }

    public NodoEstacionGrafo getEstacion() {
        return this.estacion;
    }

    public void setSigAdyacente(NodoRiel nodo) {
        this.sigAdyacente = nodo;
    }

    public NodoRiel getSigAdyacente() {
        return this.sigAdyacente;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTiempo() {
        return this.tiempo;
    }
}
