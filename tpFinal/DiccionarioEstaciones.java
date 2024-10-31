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
public class DiccionarioEstaciones {

    private NodoEstacionAVL raiz;

    public DiccionarioEstaciones() {
        this.raiz = null;
    }

    public boolean insertarEstacion(Comparable clave, Object nuevaEstacion) {
        boolean exito = true;
        if (this.esVacio()) {
            NodoEstacionAVL nuevo = new NodoEstacionAVL(clave, nuevaEstacion);
            this.raiz = nuevo;
        } else {
            exito = insertarAux(this.raiz, null, ' ', clave, nuevaEstacion);
        }
        return exito;
    }

    public boolean eliminarEstacion(Comparable aEliminar) {
        boolean exito;
        if (!this.esVacio()) {
            exito = eliminarAux(this.raiz, null, ' ', aEliminar);
        } else {
            exito = false;
        }
        return exito;
    }

    public String mostrarEstacion(Comparable buscada) {
        String encontrado = "";
        if (!this.esVacio()) {
            encontrado = mostrarAux(this.raiz, buscada);
        }
        if (encontrado.equals("")) {
            encontrado = "La estacion no se encuentra en el sistema";
        }
        return encontrado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listar() {
        Lista listado = new Lista();
        if (!this.esVacio()) {
            listarAux(this.raiz, listado);
        }
        return listado;
    }

    public Lista listarNombre(Comparable cadena) {
        Lista listado = new Lista();
        if (!this.esVacio()) {
            listarNombreAux(cadena, listado, this.raiz);
        }
        return listado;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean camibarNombre(Comparable clave, Comparable nombre) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.setClave(nombre);
            buscado.getDatos().setNombre(nombre);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean camibarCalle(Comparable clave, String calle) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setCalle(calle);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean cambiarNumCalle(Comparable clave, int num) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setNumCalle(num);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean agregarLinea(Comparable clave, Linea nuevaLinea) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().agregarLinea(nuevaLinea);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean cambiarHoraApertura(Comparable clave, String hora) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setHoraApertura(hora);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean cambiarHoraCierre(Comparable clave, String hora) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setHoraCierre(hora);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean cambiarTieneAscensor(Comparable clave, boolean tiene) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setTieneAscensor(tiene);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean cambiarTieneRampa(Comparable clave, boolean tiene) {
        NodoEstacionAVL buscado = buscarEstacion(clave);
        boolean exito;
        if (buscado != null) {
            buscado.getDatos().setTieneRampa(tiene);
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    private NodoEstacionAVL rebalancear(NodoEstacionAVL nodo, NodoEstacionAVL padre, char referenciaHijo) {
        int balance, balanceAux;
        balance = nodo.obtenerBalance();
        if (balance == 2) {
            balanceAux = nodo.getIzquierdo().obtenerBalance();
            if (balanceAux == 1 || balanceAux == 0) {
                switch (referenciaHijo) {
                    case ' ':
                        this.raiz = rotarDerecha(nodo);
                        break;
                    case 'I':
                        padre.setIzquierdo(rotarDerecha(nodo));
                        break;
                    case 'D':
                        padre.setDerecho(rotarDerecha(nodo));
                        break;
                }
            } else if (balanceAux == -1) {
                nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
                switch (referenciaHijo) {
                    case ' ':
                        this.raiz = rotarDerecha(nodo);
                        break;
                    case 'I':
                        padre.setIzquierdo(rotarDerecha(nodo));
                        break;
                    case 'D':
                        padre.setDerecho(rotarDerecha(nodo));
                        break;
                }
            }
        } else if (balance == -2) {
            balanceAux = nodo.getDerecho().obtenerBalance();
            if (balanceAux == 1) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
                switch (referenciaHijo) {
                    case ' ':
                        this.raiz = rotarIzquierda(nodo);
                        break;
                    case 'I':
                        padre.setIzquierdo(rotarIzquierda(nodo));
                        break;
                    case 'D':
                        padre.setDerecho(rotarIzquierda(nodo));
                        break;
                }
            } else if (balanceAux == -1 || balanceAux == 0) {
                switch (referenciaHijo) {
                    case ' ':
                        this.raiz = rotarIzquierda(nodo);
                        break;
                    case 'I':
                        padre.setIzquierdo(rotarIzquierda(nodo));
                        break;
                    case 'D':
                        padre.setDerecho(rotarIzquierda(nodo));
                        break;
                }
            }
        }
        return nodo;
    }

    private NodoEstacionAVL rotarIzquierda(NodoEstacionAVL nodo) {
        NodoEstacionAVL hijo = nodo.getDerecho(), temp = hijo.getIzquierdo();
        hijo.setIzquierdo(nodo);
        nodo.setDerecho(temp);
        nodo.recalcularAltura();
        hijo.recalcularAltura();
        if (temp != null) {
            temp.recalcularAltura();
        }
        return hijo;
    }

    private NodoEstacionAVL rotarDerecha(NodoEstacionAVL nodo) {
        NodoEstacionAVL hijo = nodo.getIzquierdo(), temp = hijo.getDerecho();
        hijo.setDerecho(nodo);
        nodo.setIzquierdo(temp);
        nodo.recalcularAltura();
        hijo.recalcularAltura();
        if (temp != null) {
            temp.recalcularAltura();
        }
        return hijo;
    }

    private boolean insertarAux(NodoEstacionAVL nodo, NodoEstacionAVL padre, char referenciaHijo, Comparable clave, Object estNueva) {
        boolean exito;
        if (!(nodo.getClave().compareTo(clave) == 0)) {
            if (nodo.getClave().compareTo(clave) > 0) {
                if (nodo.getIzquierdo() != null) {
                    exito = insertarAux(nodo.getIzquierdo(), nodo, 'I', clave, estNueva);
                    nodo.recalcularAltura();
                    rebalancear(nodo, padre, referenciaHijo);
                } else {
                    NodoEstacionAVL nuevo = new NodoEstacionAVL(clave, estNueva);
                    nodo.setIzquierdo(nuevo);
                    exito = true;
                    nodo.recalcularAltura();
                }
            } else if (nodo.getDerecho() != null) {
                exito = insertarAux(nodo.getDerecho(), nodo, 'D', clave, estNueva);
                nodo.recalcularAltura();
                rebalancear(nodo, padre, referenciaHijo);
            } else {
                NodoEstacionAVL nuevo = new NodoEstacionAVL(clave, estNueva);
                nodo.setDerecho(nuevo);
                exito = true;
                nodo.recalcularAltura();
            }
        } else {
            exito = false;
        }
        return exito;
    }

    private boolean eliminarAux(NodoEstacionAVL nodo, NodoEstacionAVL padre, char referenciaHijo, Comparable aEliminar) {
        boolean exito = false;
        if (nodo != null) {
            if (!(nodo.getClave().compareTo(aEliminar) == 0)) {
                if (nodo.getClave().compareTo(aEliminar) > 0) {
                    exito = eliminarAux(nodo.getIzquierdo(), nodo, 'I', aEliminar);
                    nodo.recalcularAltura();
                    rebalancear(nodo, padre, referenciaHijo);
                } else {
                    exito = eliminarAux(nodo.getDerecho(), nodo, 'D', aEliminar);
                    nodo.recalcularAltura();
                    rebalancear(nodo, padre, referenciaHijo);
                }
            } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                if (padre.getIzquierdo() != null && padre.getIzquierdo().getClave().compareTo(aEliminar) == 0) {
                    padre.setIzquierdo(null);
                    padre.recalcularAltura();
                } else {
                    padre.setDerecho(null);
                    padre.recalcularAltura();
                }
                exito = true;
            } else if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                NodoEstacionAVL aux = buscarCandidato(nodo);
                nodo.setClave(aux.getClave());
                nodo.setIzquierdo(aux.getIzquierdo());
                nodo.recalcularAltura();
                exito = true;
            } else if (nodo.getIzquierdo() != null) {
                nodo.setClave(nodo.getIzquierdo().getClave());
                nodo.setIzquierdo(null);
                nodo.recalcularAltura();
                exito = true;
            } else {
                nodo.setClave(nodo.getDerecho().getClave());
                nodo.setDerecho(null);
                nodo.recalcularAltura();
                exito = true;
            }
        }
        return exito;
    }

    private NodoEstacionAVL buscarCandidato(NodoEstacionAVL nodo) {
        NodoEstacionAVL aux = nodo;
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux;
    }

    private String mostrarAux(NodoEstacionAVL nodo, Comparable buscada) {
        String encontrado = "";
        if (nodo != null) {
            if (nodo.getClave().compareTo(buscada) == 0) {
                encontrado=nodo.getDatos().toString();
            } else if (nodo.getClave().compareTo(buscada) > 0) {
                encontrado = mostrarAux(nodo.getIzquierdo(), buscada);
            } else {
                encontrado = mostrarAux(nodo.getDerecho(), buscada);
            }
        }
        return encontrado;
    }

    private NodoEstacionAVL buscarEstacion(Comparable buscado) {
        NodoEstacionAVL encontrado = null;
        if (!this.esVacio()) {
            encontrado = buscarAux(this.raiz, buscado);
        }
        return encontrado;
    }

    private NodoEstacionAVL buscarAux(NodoEstacionAVL nodo, Comparable buscado) {
        NodoEstacionAVL encontrado = null;
        if (nodo != null) {
            if (nodo.getClave().compareTo(buscado) == 0) {
                encontrado = nodo;
            } else if (nodo.getClave().compareTo(buscado) > 0) {
                encontrado = buscarAux(nodo.getIzquierdo(), buscado);
            } else {
                encontrado = buscarAux(nodo.getDerecho(), buscado);
            }
        }
        return encontrado;
    }

    private void listarAux(NodoEstacionAVL nodo, Lista listado) {
        if (nodo != null) {
            listarAux(nodo.getIzquierdo(), listado);
            listado.insertar(nodo.getClave(), listado.longitud() + 1);
            listarAux(nodo.getDerecho(), listado);
        }
    }

    private void listarNombreAux(Comparable cadena, Lista listado, NodoEstacionAVL nodo) {
        if (nodo != null) {
            String cadAux = (String) cadena, claveAux = (String) nodo.getClave();
            if (claveAux.substring(0, cadAux.length()).compareTo(cadAux) == 0) {
                listado.insertar(claveAux, 1);
                listarNombreAux(cadena, listado, nodo.getIzquierdo());
                listarNombreAux(cadena, listado, nodo.getDerecho());
            } else if (claveAux.substring(0, cadAux.length()).compareTo(cadAux) < 0) {
                listarNombreAux(cadena, listado, nodo.getDerecho());
            } else {
                listarNombreAux(cadena, listado, nodo.getIzquierdo());
            }
        }
    }
}
