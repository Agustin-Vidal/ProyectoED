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
public class NodoTrenHash {

    private Object IdTren;
    private Object linea;
    private NodoTrenHash enlace;

    public NodoTrenHash(Object IdTren, Object linea, NodoTrenHash siguiente) {
        this.IdTren = IdTren;
        this.linea = linea;
        this.enlace = siguiente;
    }

    public Object getIdTren() {
        return this.IdTren;
    }

    public Linea getLinea() {
        return (Linea) this.linea;
    }

    public NodoTrenHash getEnlace() {
        return this.enlace;
    }

    public void setTren(Object IdTren) {
        this.IdTren = IdTren;
    }

    public void setLinea(Object linea) {
        this.linea = linea;
    }

    public void setEnlace(NodoTrenHash siguiente) {
        this.enlace = siguiente;
    }
}
