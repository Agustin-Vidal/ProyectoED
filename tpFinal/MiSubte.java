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
public class MiSubte {

    public static void main(String[] args) {

        int opcion;
        do {
            menu();
            Mapa mapa = new Mapa();
            DiccionarioEstaciones diccionario = new DiccionarioEstaciones();
            MapeoTrenes mapeo = new MapeoTrenes();
            opcion = TecladoIn.readLineInt();
            switch (opcion) {
                case 1:
                    precarga(mapa, diccionario, mapeo);
                case 2:
                    System.out.println("Ingrese el vertice a eliminar");
                    elem = TecladoIn.readLineInt();
                    if (grafo.eliminarVertice(elem)) {
                        System.out.println("Elemento eliminado exitosamente");
                    } else {
                        System.out.println("No se ha podido eliminar el elemento");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el primer vertice a enlazar");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el segundo vertice a enlazar");
                    a = TecladoIn.readLineInt();
                    if (grafo.insertarArco(elem, a)) {
                        System.out.println("Arco agregado");
                    } else {
                        System.out.println("No se ha podido crear el arco");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el vertice del cual desea eliminar un arco");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el vertice que desea desconectar");
                    a = TecladoIn.readLineInt();
                    if (grafo.eliminarArco(elem, a)) {
                        System.out.println("Arco eliminado");
                    } else {
                        System.out.println("No se ha podido eliminar el arco");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el elemento el cual desea verificar");
                    elem = TecladoIn.readLineInt();
                    if (grafo.existeVertice(elem)) {
                        System.out.println("El elemento se encuentra en el grafo");
                    } else {
                        System.out.println("El elemento no se encuentra en el grafo");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el primer vertice del cual desea verificar un arco");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el segundo vertice");
                    a = TecladoIn.readLineInt();
                    if (grafo.existeArco(elem, a)) {
                        System.out.println("El arco entre esos vertices existe");
                    } else {
                        System.out.println("El arco no existe");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el primer vertice del cual desea verificar su camino");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el segundo vertice");
                    a = TecladoIn.readLineInt();
                    if (grafo.existeCamino(elem, a)) {
                        System.out.println("Existe un camino entre esos vertices");
                    } else {
                        System.out.println("No existe un camino entre esos vertices");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el primer vertice del cual desea verificar su camino mas corto");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el segundo vertice");
                    a = TecladoIn.readLineInt();
                    System.out.println(grafo.caminoMasCorto(elem, a));
                    break;
                case 9:
                    System.out.println("Ingrese el primer vertice del cual desea verificar su camino mas largo");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese el segundo vertice");
                    a = TecladoIn.readLineInt();
                    System.out.println(grafo.caminoMasLargo(elem, a));
                    break;
                case 10:
                    System.out.println(grafo.listarEnProfundidad());
                    break;
                case 11:
                    System.out.println(grafo.listarEnAnchura());
                    break;
                case 12:
                    if (grafo.esVacio()) {
                        System.out.println("Grafo vacio");
                    } else {
                        System.out.println("El grafo no esta vacio");
                    }
                    break;
                case 13:
                    System.out.println(grafo.toString());
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public static void menu() {
        // Mod que muestra un menu de opciones
        System.out.println("________________________________________________");
        System.out.println("1. Realizar carga automatica");
        System.out.println("2. Eliminar un vertice");
        System.out.println("3. Insertar un arco");
        System.out.println("4. Eliminar un arco");
        System.out.println("5. Verificar si existe un vertice");
        System.out.println("6. Verificar si existe un arco entre 2 vertices");
        System.out.println("7. Verificar si existe un camino entre 2 vertices");
        System.out.println("8. Obtener el camino mas corto entre 2 vertices");
        System.out.println("9. Obtener el camino mas largo entre 2 vertices");
        System.out.println("10. Listar en profundidad");
        System.out.println("11. Listar en anchura");
        System.out.println("12. Verificar si el grafo es vacio");
        System.out.println("13. Mostrar el grafo");
        System.out.println("");
        System.out.println("0. Salir");
        System.out.println("________________________________________________");
        System.out.println("Ingrese una opcion");
    }

    public static void precarga(Mapa mapa, DiccionarioEstaciones diccionario, MapeoTrenes mapeo) {
        Estacion pinar = new Estacion("PINAR", "CHAMARTIN", 500, "06:00", "01:30", true, true);
        Estacion valde = new Estacion("VALDECARROS", "LAS SUERTES", 1880, "06:00", "01:30", true, true);
        Linea lineaA = new Linea("LINEA A", "CELESTE", pinar, valde);
        pinar.agregarLinea(lineaA);
        valde.agregarLinea(lineaA);
        Estacion caminos = new Estacion("4 CAMINOS", "RETIRO", 600, "06:00", "01:30", true, true);
        Estacion rosas = new Estacion("LAS ROSAS", "ELIPA", 900, "06:00", "01:30", true, true);
        Linea lineaB = new Linea("LINEA B", "ROJO", caminos, rosas);
        caminos.agregarLinea(lineaB);
        caminos.agregarLinea(lineaA);
        rosas.agregarLinea(lineaB);
        Estacion villa = new Estacion("VILLAVERDE", "DELICIAS", 1540, "06:00", "01:30", true, true);
        Estacion moncloa = new Estacion("MOCLOA", "ALMENDRADES", 120, "06:00", "01:30", true, true);
        Linea lineaC = new Linea("LINEA C", "AMARILLO", villa, moncloa);
        villa.agregarLinea(lineaC);
        moncloa.agregarLinea(lineaC);
        Estacion arguelles = new Estacion("ARGUELLES", "COLON", 350, "06:00", "01:30", true, true);
        Estacion mar = new Estacion("MAR DE CRISTAL", "SERRANO", 730, "06:00", "01:30", true, true);
        Linea lineaD = new Linea("LINEA D", "MARRON", arguelles, mar);
        arguelles.agregarLinea(lineaD);
        mar.agregarLinea(lineaD);
        Estacion alam = new Estacion("ALAMEDA", "ASZUNA", 2000, "06:00", "01:30", true, true);
        Estacion opor = new Estacion("OPORTO", "PORTUGAL", 1200, "06:00", "01:30", true, true);
        Linea lineaE = new Linea("LINEA E", "VERDE", alam, opor);
        alam.agregarLinea(lineaE);
        opor.agregarLinea(lineaE);
        Estacion chamar = new Estacion("CHAMARTIN", "CHOMOR", 1500, "06:00", "01:30", true, true);
        Estacion plaza = new Estacion("PLAZA CASTILLA", "LEON", 180, "06:00", "01:30", true, true);
        Estacion alv = new Estacion("ALVARADO", "CHAMARTIN", 500, "06:00", "01:30", true, true);
        Estacion bilb = new Estacion("BILBAO", "LAS SUERTES", 1880, "06:00", "01:30", true, true);
        Estacion trib = new Estacion("TRIBUNAL", "MORROWIND", 300, "06:00", "01:30", true, true);
        Estacion sol = new Estacion("SOL", "RA", 2080, "06:00", "01:30", true, true);
        Estacion pac = new Estacion("PACIFICO", "ATLANTICO", 500, "06:00", "01:30", true, true);
        chamar.agregarLinea(lineaA);
        plaza.agregarLinea(lineaA);
        alv.agregarLinea(lineaA);
        bilb.agregarLinea(lineaA);
        bilb.agregarLinea(lineaD);
        trib.agregarLinea(lineaA);
        sol.agregarLinea(lineaA);
        sol.agregarLinea(lineaB);
        sol.agregarLinea(lineaC);
        pac.agregarLinea(lineaA);
        Estacion canal = new Estacion("CANAL", "VENECIA", 1500, "06:00", "01:30", true, false);
        Estacion plazaEsp = new Estacion("PLAZA ESPAÑA", "PAELLA", 880, "08:00", "00:30", true, false);
        Estacion opera = new Estacion("OPERA", "BARNES", 423, "08:00", "00:30", true, false);
        Estacion banco = new Estacion("BANCO DE ESPAÑA", "WARIO", 1080, "08:00", "00:30", true, false);
        Estacion goya = new Estacion("GOYA", "MADAME", 2500, "08:00", "00:30", true, false);
        Estacion venta = new Estacion("VENTA", "PLATA", 100, "06:00", "01:30", true, false);
        canal.agregarLinea(lineaB);
        canal.agregarLinea(lineaD);
        plazaEsp.agregarLinea(lineaB);
        plazaEsp.agregarLinea(lineaC);
        opera.agregarLinea(lineaE);
        opera.agregarLinea(lineaB);
        banco.agregarLinea(lineaB);
        goya.agregarLinea(lineaB);
        goya.agregarLinea(lineaD);
        venta.agregarLinea(lineaB);
        venta.agregarLinea(lineaE);
        Estacion callao = new Estacion("CALLAO", "FLORIDA", 500, "06:00", "01:30", true, false);
        Estacion embajadores = new Estacion("EMBAJADORES", "PAZ", 80, "07:00", "01:30", false, false);
        Estacion legapazi = new Estacion("LEGAPAZI", "MIZCUZI", 400, "07:00", "00:30", false, false);
        callao.agregarLinea(lineaC);
        callao.agregarLinea(lineaE);
        embajadores.agregarLinea(lineaC);
        embajadores.agregarLinea(lineaE);
        legapazi.agregarLinea(lineaC);
        Estacion alonso = new Estacion("ALONSO MARTINEZ", "ACTOR", 600, "08:00", "00:30", true, true);
        Estacion nun = new Estacion("NUÑEZ BALBOA", "RICKY", 1600, "08:00", "00:30", true, true);
        Estacion leon = new Estacion("DIEGO LEON", "BAMBU", 880, "07:00", "01:30", true, false);
        Estacion prosp = new Estacion("PROSPERIDAD", "ESPERANZA", 2400, "06:00", "01:30", true, true);
        alonso.agregarLinea(lineaD);
        alonso.agregarLinea(lineaE);
        nun.agregarLinea(lineaD);
        leon.agregarLinea(lineaD);
        leon.agregarLinea(lineaE);
        prosp.agregarLinea(lineaD);
        Estacion puerto = new Estacion("PUERTO NUEVO", "NUEVA ESCOCIA", 1400, "06:00", "01:30", true, true);
        puerto.agregarLinea(lineaE);
        mapa.insertarEstacion(pinar);
        diccionario.insertarEstacion("PINAR", pinar);
        mapa.insertarEstacion(valde);
        diccionario.insertarEstacion("VALDECARROS", valde);
        mapa.insertarEstacion(chamar);
        diccionario.insertarEstacion("CHAMAR", chamar);
        mapa.insertarEstacion(plaza);
        diccionario.insertarEstacion("PLAZA CASTILLA", plaza);
        mapa.insertarEstacion(alv);
        diccionario.insertarEstacion("ALVARADO", alv);
        mapa.insertarEstacion(bilb);
        diccionario.insertarEstacion("BILBAO", bilb);
        mapa.insertarEstacion(trib);
        diccionario.insertarEstacion("TRIBUNAL", trib);
        mapa.insertarEstacion(sol);
        diccionario.insertarEstacion("SOL", sol);
        mapa.insertarEstacion(pac);
        diccionario.insertarEstacion("PACIFICO", pac);
        mapa.insertarEstacion(caminos);
        diccionario.insertarEstacion("4 CAMINOS", caminos);
        mapa.insertarEstacion(rosas);
        diccionario.insertarEstacion("LAS ROSAS", rosas);
        mapa.insertarEstacion(canal);
        diccionario.insertarEstacion("CANAL", canal);
        mapa.insertarEstacion(plazaEsp);
        diccionario.insertarEstacion("PLAZA ESPAÑA", plazaEsp);
        mapa.insertarEstacion(opera);
        diccionario.insertarEstacion("OPERA", opera);
        mapa.insertarEstacion(banco);
        diccionario.insertarEstacion("BANCO DE ESPAÑA", banco);
        mapa.insertarEstacion(goya);
        diccionario.insertarEstacion("GOYA", goya);
        mapa.insertarEstacion(venta);
        diccionario.insertarEstacion("VENTA", venta);
        mapa.insertarEstacion(villa);
        diccionario.insertarEstacion("VILLAVERDE", villa);
        mapa.insertarEstacion(moncloa);
        diccionario.insertarEstacion("MONCLOA", moncloa);
        mapa.insertarEstacion(callao);
        diccionario.insertarEstacion("CALLAO", callao);
        mapa.insertarEstacion(embajadores);
        diccionario.insertarEstacion("EMBAJADORES", embajadores);
        mapa.insertarEstacion(legapazi);
        diccionario.insertarEstacion("LEGAPAZI", legapazi);
        mapa.insertarEstacion(arguelles);
        diccionario.insertarEstacion("ARGUELLES", arguelles);
        mapa.insertarEstacion(mar);
        diccionario.insertarEstacion("MAR DE CRISTAL", mar);
        mapa.insertarEstacion(alonso);
        diccionario.insertarEstacion("ALoNSO", alonso);
        mapa.insertarEstacion(nun);
        diccionario.insertarEstacion("NUÑEZ BALBOA", nun);
        mapa.insertarEstacion(leon);
        diccionario.insertarEstacion("DIEGO LEON", leon);
        mapa.insertarEstacion(prosp);
        diccionario.insertarEstacion("PROSPERIDAD", prosp);
        mapa.insertarEstacion(alam);
        diccionario.insertarEstacion("ALAMEDA", alam);
        mapa.insertarEstacion(opor);
        diccionario.insertarEstacion("OPORTO", opor);
        mapa.insertarEstacion(puerto);
        diccionario.insertarEstacion("PUERTO NUEVO", puerto);
        mapa.insertarRiel(pinar, chamar, 5);
        mapa.insertarRiel(chamar, plaza, 2);
        mapa.insertarRiel(plaza, alv, 6);
        mapa.insertarRiel(alv, bilb, 5);
        mapa.insertarRiel(bilb, trib, 7);
        mapa.insertarRiel(bilb, alonso, 3);
        mapa.insertarRiel(bilb, canal, 3);
        mapa.insertarRiel(trib, sol, 2);
        mapa.insertarRiel(sol, banco, 7);
        mapa.insertarRiel(sol, embajadores, 8);
        mapa.insertarRiel(sol, pac, 10);
        mapa.insertarRiel(sol, opera, 3);
        Estacion pinar = new Estacion("PINAR", "CHAMARTIN", 500, "06:00", "01:30", true, true);
        Estacion valde = new Estacion("VALDECARROS", "LAS SUERTES", 1880, "06:00", "01:30", true, true);
        Estacion chamar = new Estacion("CHAMARTIN", "CHOMOR", 1500, "06:00", "01:30", true, true);
        Estacion plaza = new Estacion("PLAZA CASTILLA", "LEON", 180, "06:00", "01:30", true, true);
        Estacion alv = new Estacion("ALVARADO", "CHAMARTIN", 500, "06:00", "01:30", true, true);
        Estacion bilb = new Estacion("BILBAO", "LAS SUERTES", 1880, "06:00", "01:30", true, true);
        Estacion trib = new Estacion("TRIBUNAL", "MORROWIND", 300, "06:00", "01:30", true, true);
        Estacion sol = new Estacion("SOL", "RA", 2080, "06:00", "01:30", true, true);
        Estacion pac = new Estacion("PACIFICO", "ATLANTICO", 500, "06:00", "01:30", true, true);
    }
}
