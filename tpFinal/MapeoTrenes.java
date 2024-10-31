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
public class MapeoTrenes {

    private static final int TAM = 200;
    private NodoTrenHash[] hash;
    private int cant = 0;

    public MapeoTrenes() {
        this.hash = new NodoTrenHash[TAM];
    }

    public boolean existeTren(Object idTren) {
        boolean encontrado = false;
        int pos = idTren.hashCode() % this.TAM;
        if (!this.esVacia()) {
            NodoTrenHash aux = this.hash[pos];
            while (!encontrado && aux != null) {
                encontrado = aux.getIdTren().equals(idTren);
                aux = aux.getEnlace();
            }
        }
        return encontrado;
    }

    public boolean agregarTren(Object idTren, Object linea) {
        int pos = idTren.hashCode() % this.TAM;
        boolean encontrado = this.existeTren(idTren);
        if (!encontrado) {
            this.hash[pos] = new NodoTrenHash(idTren, linea, this.hash[pos]);
            this.cant++;
        }
        return !encontrado;
    }

    public boolean quitarTren(Object idTren) {
        int pos = idTren.hashCode() % this.TAM;
        boolean exito = false;
        NodoTrenHash aux = this.hash[pos];
        if (!this.esVacia()) {
            if (aux != null) {
                if (aux.getIdTren().equals(idTren)) {
                    this.hash[pos] = aux.getEnlace();
                    exito = true;
                    this.cant--;
                } else {
                    NodoTrenHash aux2 = aux.getEnlace();
                    while (!exito && aux2 != null) {
                        if (aux2.getIdTren().equals(idTren)) {
                            aux.setEnlace(aux2.getEnlace());
                            exito = true;
                            this.cant--;
                        }
                        aux = aux.getEnlace();
                        aux2 = aux2.getEnlace();
                    }
                }
            }
        }
        return exito;
    }

    public boolean esVacia() {
        return this.cant == 0;
    }

    public String mostrarTren(Object idTren) {
        String idTrenBuscado = "";
        int pos = idTren.hashCode() % this.TAM;
        boolean encontrado = false;
        if (!this.esVacia()) {
            NodoTrenHash aux = this.hash[pos];
            while (!encontrado && aux != null) {
                encontrado = aux.getIdTren().equals(idTren);
                if (encontrado) {
                    idTrenBuscado = "Tren: " + aux.getIdTren().toString() + " Linea: " + aux.getLinea().getIdentificador();
                }
                aux = aux.getEnlace();
            }
        }
        if (idTrenBuscado.equals("")) {
            idTrenBuscado = "El idTren no se encuentra en el sistema";
        }
        return idTrenBuscado;
    }

    public boolean cambiarIdTren(Object idTren, Object nuevaId) {
        int pos = idTren.hashCode() % this.TAM;
        boolean exito = false;
        if (!this.esVacia()) {
            NodoTrenHash aux = this.hash[pos];
            while (!exito && aux != null) {
                exito = aux.getIdTren().equals(idTren);
                if (exito) {
                    agregarTren(nuevaId, aux.getLinea());
                    quitarTren(idTren);
                }
                aux = aux.getEnlace();
            }
        }
        return exito;
    }

    public boolean cambiarLinea(Object idTren, Object nuevaLinea) {
        int pos = idTren.hashCode() % this.TAM;
        boolean exito = false;
        if (!this.esVacia()) {
            NodoTrenHash aux = this.hash[pos];
            while (!exito && aux != null) {
                exito = aux.getIdTren().equals(idTren);
                if (exito) {
                    aux.setLinea(nuevaLinea);
                }
                aux = aux.getEnlace();
            }
        }
        return exito;
    }

    public Lista obtenerConjuntoDominio() {
        Lista listado = new Lista();
        NodoTrenHash aux;
        int pos = 0;
        if (!this.esVacia()) {
            while (pos < this.TAM) {
                aux = this.hash[pos];
                if (aux != null) {
                    while (aux != null) {
                        listado.insertar(aux.getIdTren(), listado.longitud() + 1);
                        aux = aux.getEnlace();
                    }
                }
                pos++;
            }
        }
        return listado;
    }
}
