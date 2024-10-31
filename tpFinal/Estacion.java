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
public class Estacion {

    private Comparable nombre;
    private String calle;
    private int numCalle;
    private Lista lineas;
    private String horaApertura;
    private String horaCierre;
    private boolean tieneAscensor;
    private boolean tieneRampa;

    public Estacion(Comparable nombre, String calle, int nCalle, String hApertura, String hCierre, boolean ascensor, boolean rampa) {
        this.nombre = nombre;
        this.calle = calle;
        this.numCalle = nCalle;
        this.lineas = new Lista();
        this.horaApertura = hApertura;
        this.horaCierre = hCierre;
        this.tieneAscensor = ascensor;
        this.tieneRampa = rampa;
    }

    public void setNombre(Comparable nombre) {
        this.nombre = nombre;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumCalle(int num) {
        this.numCalle = num;
    }

    public void agregarLinea(Object nuevaLinea) {
        lineas.insertar(nuevaLinea, lineas.longitud() + 1);
    }

    public void setHoraApertura(String hora) {
        this.horaApertura = hora;
    }

    public void setHoraCierre(String hora) {
        this.horaCierre = hora;
    }

    public void setTieneAscensor(boolean tiene) {
        this.tieneAscensor = tiene;
    }

    public void setTieneRampa(boolean tiene) {
        this.tieneRampa = tiene;
    }

    public Comparable getNombre() {
        return this.nombre;
    }

    public String getCalle() {
        return this.calle;
    }

    public int getNumCalle() {
        return this.numCalle;
    }

    public Lista getLineas() {
        return this.lineas;
    }

    public String getHoraApertura() {
        return this.horaApertura;
    }

    public String getHoraCierre() {
        return this.horaCierre;
    }

    public boolean getTieneAscensor() {
        return this.tieneAscensor;
    }

    public boolean getTieneRampa() {
        return this.tieneRampa;
    }

    public String toString() {
        String tren = " ";
        tren += "Estacion " + this.getNombre() + ", Domicilio: " + this.getCalle() + " " + this.getNumCalle()
                + ", Linea/s: " + this.getLineas().toString() + ", Abierta de " + this.getHoraApertura() + " a " + this.getHoraCierre() + ", Ascensor: ";
        if (this.getTieneAscensor()) {
            tren += "Si, Rampa: ";
        } else {
            tren += "No, Rampa: ";
        }
        if (this.getTieneRampa()) {
            tren += "Si.";
        } else {
            tren += "No.";
        }
        return tren;
    }

}
