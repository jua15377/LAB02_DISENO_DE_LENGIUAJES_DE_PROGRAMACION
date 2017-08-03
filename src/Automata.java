/*
* Tomando de referencia la clase DirectedGraph
* encontrada en:
* https://github.com/shaunak1111/Directed-Graph-Implementation-java/blob/master/DirectedGraph.java*/

import sun.security.util.AuthResources;

import java.util.HashMap;
import java.util.HashSet;

public class Automata {
    /*
    * atributos donde se guarada la informacion del automata*/
    private  HashSet<Estado> estados = new HashSet<Estado>();
    private  HashSet<Trancision> transicoines = new HashSet<Trancision>();
    private  HashMap<Integer, Estado> mapaDeEstados = new HashMap<Integer,Estado>();
    /*
    * Constructor
    * */
    public Automata(){
    }
    /**
     * Crea un nodo  y lo agrega al automata
     */
    public void addEstado(Automata a, int idEstaod, boolean esInicial, boolean esFinal){
        Estado estadoNuevo = new Estado(esInicial, esFinal, idEstaod);
        a.estados.add(estadoNuevo);
        a.mapaDeEstados.put(idEstaod,estadoNuevo);
    }

    /**
     * otra forma de agregar nodos
     */
    public void addEstado(Automata a, Estado estadoAgregar){
        a.estados.add(estadoAgregar);
        a.mapaDeEstados.put(estadoAgregar.getIdentifiacador(),estadoAgregar);
    }

    /**
     * Crea y agrega una transicion
     */
    public void addTrancion(Automata a, Estado estInicial, Estado estFinal, String transition ){
        Trancision t = new Trancision(estInicial, estFinal, transition);
        a.transicoines.add(t);
    }

    /**
     * Agregar una transicion existente
     */
    public void addTrancion(Automata a, Trancision t){
        a.transicoines.add(t);
    }


    /**
     * Obtiene el nodo inicial del automata
     */
    public Estado getEstadoInicale(){
        HashSet<Estado> estados = getTodosLosEstados();
        for (Estado i : estados) {
            // Buscar el nodo inicial
            if (i.getEsinicial()){
                return i;
            }
        }return null;
    }
    /**
     * Devuelve el hasset de los Estados
     */
    public HashSet<Estado> getTodosLosEstados(){
        return estados;
    }
    /**
     * Obtiene el nodo final del automata
     */
    public Estado getEstadoFinal(){
        HashSet<Estado> estados = getTodosLosEstados();
        for (Estado i : estados) {
            // Buscar el nodo final
            if (i.getEsFinal()) {
                return i;
            }
        }return null;
    }
    /**
     * Obtiene un nodo especifico
     */
    public  Estado obtenerUnNodo(int id){
        if (mapaDeEstados.containsKey(id))
            return mapaDeEstados.get(id);
//        encaso no exista devulve null
        return null;
    }

    /**
     * setter y getters
     */
    public HashSet<Estado> getEstados() {
        return estados;
    }

    public HashSet<Trancision> getTransicoines() {
        return transicoines;
    }

    public HashMap<Integer, Estado> getMapaDeEstados() {
        return mapaDeEstados;
    }
    @Override
    public String toString(){
//        imprimir Estados
        HashSet<Estado> estados = getTodosLosEstados();
        String resultNodos = "Estados: {";
        int contador = 0;
        for (Estado i: estados) {
            resultNodos = resultNodos + String.valueOf((i.getIdentifiacador()));
            if (contador < estados.size()-1){
                resultNodos = resultNodos + ", ";
            }
            else {
                resultNodos = resultNodos + "}\n";
            }
            contador ++;
        }

        resultNodos += "\t- Son " + contador + " estados\n";
        return  resultNodos;
    }
}
