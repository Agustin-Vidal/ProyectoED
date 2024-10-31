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
public class Linea {

    private String identificador;
    private String color;
    private Estacion inicio;
    private Estacion fin;

    public Linea(String id, String color, Estacion inicio, Estacion fin) {
        this.identificador = id;
        this.color = color;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setInicio(Estacion est) {
        this.inicio = est;
    }

    public void setFin(Estacion est) {
        this.fin = est;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public String getColor() {
        return this.color;
    }

    public Estacion getInicio() {
        return this.inicio;
    }

    public Estacion getFin() {
        return this.fin;
    }
}
