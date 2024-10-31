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
public class Mapa {

    private NodoEstacionGrafo inicio;

    public Mapa() {
        inicio = null;
    }

    public boolean insertarEstacion(Object estacion) {
        boolean exito = false;
        NodoEstacionGrafo aux = ubicarEstacion(estacion);
        if (aux == null) {
            this.inicio = new NodoEstacionGrafo(estacion, this.inicio);
            exito = true;
        }
        return exito;
    }

    public boolean eliminarEstacion(Object estacion) {
        boolean exito = false;
        NodoEstacionGrafo aux = this.inicio;
        if (aux != null) {
            exito = eliminarEstacionAux(aux, null, estacion);
        }
        return exito;
    }

    public boolean insertarRiel(Object origen, Object destino, int etiqueta) {
        boolean exito = false, arcoEncontradoO = false, arcoEncontradoD = false;
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        if (nodoO != null) {
            NodoEstacionGrafo nodoD = ubicarEstacion(destino);
            if (nodoD != null) {
                NodoRiel aux = nodoO.getPrimerAdy();
                while (!arcoEncontradoO && aux != null) {
                    if (aux.getEstacion().getNombre().equals(nodoD.getNombre())) {
                        arcoEncontradoO = true;
                    }
                    aux = aux.getSigAdyacente();
                }
                aux = nodoD.getPrimerAdy();
                while (!arcoEncontradoD && aux != null) {
                    if (aux.getEstacion().getNombre().equals(nodoO.getNombre())) {
                        arcoEncontradoO = true;
                    }
                    aux = aux.getSigAdyacente();
                }
                if (!arcoEncontradoO && !arcoEncontradoD) {
                    nodoO.setPrimerAdy(new NodoRiel(nodoD, nodoO.getPrimerAdy(), etiqueta));
                    nodoD.setPrimerAdy(new NodoRiel(nodoO, nodoD.getPrimerAdy(), etiqueta));
                    exito = true;
                }
            }
        }
        return exito;
    }

    public boolean eliminarRiel(Object origen, Object destino) {
        boolean exito = false, primerElim = false;
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        if (nodoO != null) {
            NodoRiel aux = nodoO.getPrimerAdy();
            NodoEstacionGrafo nodoD = null;
            if (aux != null && aux.getEstacion().getNombre().equals(destino)) {
                nodoO.setPrimerAdy(aux.getSigAdyacente());
                primerElim = true;
                nodoD = aux.getEstacion();
            } else {
                while (aux != null && !primerElim) {
                    if (aux.getSigAdyacente() != null && aux.getSigAdyacente().getEstacion().getNombre().equals(destino)) {
                        nodoD = aux.getSigAdyacente().getEstacion();
                        aux.setSigAdyacente(aux.getSigAdyacente().getSigAdyacente());
                        primerElim = true;
                    } else {
                        aux = aux.getSigAdyacente();
                    }
                }
            }
            if (primerElim && nodoD != null) {
                aux = nodoD.getPrimerAdy();
                if (aux != null && aux.getEstacion().getNombre().equals(origen)) {
                    nodoD.setPrimerAdy(aux.getSigAdyacente());
                    exito = true;
                } else {
                    while (aux != null && !exito) {
                        if (aux.getSigAdyacente() != null && aux.getSigAdyacente().getEstacion().getNombre().equals(origen)) {
                            aux.setSigAdyacente(aux.getSigAdyacente().getSigAdyacente());
                            exito = true;;
                        } else {
                            aux = aux.getSigAdyacente();
                        }
                    }
                }
            }
        }
        return exito;
    }

    public boolean existeEstacion(Object estacion) {
        boolean exito = false;
        NodoEstacionGrafo aux = this.inicio;
        while (!exito && aux != null) {
            exito = aux.getNombre().equals(estacion);
            aux = aux.getSigEstacion();
        }
        return exito;
    }

    public boolean existeRiel(Object origen, Object destino) {
        boolean exito = false;
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        if (nodoO != null) {
            NodoRiel aux = nodoO.getPrimerAdy();
            while (!exito && aux != null) {
                exito = aux.getEstacion().getNombre().equals(destino);
                aux = aux.getSigAdyacente();
            }
        }
        return exito;
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        NodoEstacionGrafo nodoD = ubicarEstacion(destino);
        if (nodoO != null && nodoD != null) {
            Lista visitados = new Lista();
            exito = existeCaminoAux(nodoO, destino, visitados);
        }
        return exito;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        Lista visitados = new Lista();
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        NodoEstacionGrafo nodoD = ubicarEstacion(destino);
        if (nodoO != null && nodoD != null) {
            visitados = caminoMasCortoAux(nodoO, destino, visitados, new Lista());
        }
        return visitados;
    }

    public Lista caminoDeMenosTiempo(Object origen, Object destino) {
        Lista visitados = new Lista();
        NodoEstacionGrafo nodoO = ubicarEstacion(origen);
        NodoEstacionGrafo nodoD = ubicarEstacion(destino);
        if (nodoO != null && nodoD != null) {
            visitados = caminoDeMenosTiempoAux(nodoO, destino, visitados, new Lista());
        }
        return visitados;
    }

    public Lista listarEnProfundidad() {
        Lista visitados = new Lista();
        if (!this.esVacio()) {
            NodoEstacionGrafo aux = this.inicio;
            while (aux != null) {
                if (visitados.localizar(aux.getNombre()) < 0) {
                    listarEnProfundidadAux(aux, visitados);
                }
                aux = aux.getSigEstacion();
            }
        }
        return visitados;
    }

    public boolean esVacio() {
        return this.inicio == null;
    }

    public String toString() {
        String cadena = "";
        if (this.esVacio()) {
            cadena = "No hay estaciones cargadas en el sistema";
        } else {
            NodoEstacionGrafo aux = this.inicio;
            while (aux != null) {
                cadena += toStringAux(aux);
                aux = aux.getSigEstacion();
            }
        }
        return cadena;
    }

    public boolean cambiarNombreEstacion(Object estacion, Object nuevoNombre) {
        boolean exito = false;
        NodoEstacionGrafo buscada = ubicarEstacion(estacion);
        if (buscada != null) {
            buscada.setNombre(nuevoNombre);
            exito = true;
        }
        return exito;
    }

    public boolean cambiarTiempoRieles(Object estOrigen, Object estDestino, int nuevoTiempo) {
        boolean exito = false;
        NodoEstacionGrafo origen = ubicarEstacion(estOrigen);
        if (origen != null) {
            NodoRiel aux = origen.getPrimerAdy();
            while (!exito && aux != null) {
                if (aux.getEstacion().getNombre().equals(origen.getNombre())) {
                    aux.setTiempo(nuevoTiempo);
                    exito = true;
                }
                aux = aux.getSigAdyacente();
            }
        }
        return exito;
    }

    private NodoEstacionGrafo ubicarEstacion(Object buscado) {
        NodoEstacionGrafo aux = this.inicio;
        while (aux != null && !aux.getNombre().equals(buscado)) {
            aux = aux.getSigEstacion();
        }
        return aux;
    }

    private boolean eliminarEstacionAux(NodoEstacionGrafo nodo, NodoEstacionGrafo padre, Object estacion) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getNombre().equals(estacion)) {
                if (nodo.getNombre().equals(this.inicio.getNombre())) {
                    this.inicio = this.inicio.getSigEstacion();
                } else {
                    padre.setSigEstacion(nodo.getSigEstacion());
                }
                exito = true;
                NodoRiel aux = nodo.getPrimerAdy();
                while (aux != null) {
                    NodoRiel auxAdy = aux.getEstacion().getPrimerAdy();
                    if (auxAdy != null && auxAdy.getEstacion().getNombre().equals(estacion)) {
                        aux.getEstacion().setPrimerAdy(auxAdy.getSigAdyacente());
                    } else {
                        boolean arcoElim = false;
                        while (auxAdy != null && !arcoElim) {
                            if (auxAdy.getSigAdyacente() != null && auxAdy.getSigAdyacente().getEstacion().getNombre().equals(estacion)) {
                                auxAdy.setSigAdyacente(auxAdy.getSigAdyacente().getSigAdyacente());
                                arcoElim = true;
                            } else {
                                auxAdy = auxAdy.getSigAdyacente();
                            }
                        }
                    }
                    aux = aux.getSigAdyacente();
                }
            } else {
                exito = eliminarEstacionAux(nodo.getSigEstacion(), nodo, estacion);
            }
        }
        return exito;
    }

    private boolean existeCaminoAux(NodoEstacionGrafo nodo, Object destino, Lista visitados) {
        boolean exito = false;
        if (nodo != null) {
            visitados.insertar(nodo.getNombre(), 1);
            if (nodo.getNombre().equals(destino)) {
                exito = true;
            } else {
                NodoRiel aux = nodo.getPrimerAdy();
                while (!exito && aux != null) {
                    if (visitados.localizar(aux.getEstacion().getNombre()) < 0) {
                        exito = existeCaminoAux(aux.getEstacion(), destino, visitados);
                    }
                    aux = aux.getSigAdyacente();
                }
            }
        }
        return exito;
    }

    private Lista caminoMasCortoAux(NodoEstacionGrafo nodo, Object destino, Lista visitados, Lista camCorto) {
        if (nodo != null) {
            visitados.insertar(nodo.getNombre(), 1);
            if (nodo.getNombre().equals(destino)) {
                if (camCorto.esVacia() || visitados.longitud() < camCorto.longitud()) {
                    camCorto = visitados.clonar();
                }
            } else {
                NodoRiel aux = nodo.getPrimerAdy();
                while (aux != null) {
                    if (visitados.localizar(aux.getEstacion().getNombre()) < 0) {
                        camCorto = caminoMasCortoAux(aux.getEstacion(), destino, visitados, camCorto);
                    }
                    aux = aux.getSigAdyacente();
                }
            }
            visitados.eliminar(1);
        }
        return camCorto;
    }

    private Lista caminoDeMenosTiempoAux(NodoEstacionGrafo nodo, Object destino, Lista visitados, Lista camCorto) {
        if (nodo != null) {
            visitados.insertar(nodo.getNombre(), 1);
            if (nodo.getNombre().equals(destino)) {
                if (camCorto.esVacia() || calcularTiempo(visitados) < calcularTiempo(camCorto)) {
                    camCorto = visitados.clonar();
                }
            } else {
                NodoRiel aux = nodo.getPrimerAdy();
                while (aux != null) {
                    if (visitados.localizar(aux.getEstacion().getNombre()) < 0) {
                        camCorto = caminoDeMenosTiempoAux(aux.getEstacion(), destino, visitados, camCorto);
                    }
                    aux = aux.getSigAdyacente();
                }
            }
            visitados.eliminar(1);
        }
        return camCorto;
    }

    private int calcularTiempo(Lista camino) {
        int tiempo = 0;
        NodoEstacionGrafo aux = (NodoEstacionGrafo) camino.recuperar(1);
        while (aux != null && camino.longitud() > 1) {
            NodoRiel conexAux = aux.getPrimerAdy();
            while (!(conexAux.getEstacion().getNombre().equals(((NodoEstacionGrafo) camino.recuperar(2)).getNombre()))) {
                conexAux = conexAux.getSigAdyacente();
            }
            tiempo = tiempo + conexAux.getTiempo();
            camino.eliminar(1);
            aux = (NodoEstacionGrafo) camino.recuperar(1);
        }
        return tiempo;
    }

    private void listarEnProfundidadAux(NodoEstacionGrafo nodo, Lista visitados) {
        if (nodo != null) {
            visitados.insertar(nodo.getNombre(), visitados.longitud() + 1);
            NodoRiel aux = nodo.getPrimerAdy();
            while (aux != null) {
                if (visitados.localizar(aux.getEstacion().getNombre()) < 0) {
                    listarEnProfundidadAux(aux.getEstacion(), visitados);
                }
                aux = aux.getSigAdyacente();
            }
        }
    }

    private String toStringAux(NodoEstacionGrafo nodo) {
        String cadena = "";
        if (nodo != null) {
            cadena += "Estacion " + nodo.getNombre().toString();
            NodoRiel aux = nodo.getPrimerAdy();
            if (aux != null) {
                cadena += ": ";
            } else {
                cadena += ", ";
            }
            while (aux != null) {
                cadena += "Estacion adyacente " + aux.getEstacion().getNombre().toString() + ", con un tiempo de recorrido: " + aux.getTiempo() + "; ";
                aux = aux.getSigAdyacente();
            }
            if (nodo.getSigEstacion() != null) {
                cadena += "\n";
            }
        }
        return cadena;
    }
}
