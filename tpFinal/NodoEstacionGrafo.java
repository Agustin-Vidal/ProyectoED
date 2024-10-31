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
public class NodoEstacionGrafo {

    private Object nombre;
    private NodoEstacionGrafo sigEstacion;
    private NodoRiel primerAdy;

    public NodoEstacionGrafo(Object nombre, NodoEstacionGrafo estacion) {
        this.nombre = nombre;
        this.sigEstacion = estacion;
    }

    public void setNombre(Object nombre) {
        this.nombre = nombre;
    }

    public Object getNombre() {
        return this.nombre;
    }

    public void setSigEstacion(NodoEstacionGrafo estacion) {
        this.sigEstacion = estacion;
    }

    public NodoEstacionGrafo getSigEstacion() {
        return this.sigEstacion;
    }

    public void setPrimerAdy(NodoRiel nodo) {
        this.primerAdy = nodo;
    }

    public NodoRiel getPrimerAdy() {
        return this.primerAdy;
    }
}
