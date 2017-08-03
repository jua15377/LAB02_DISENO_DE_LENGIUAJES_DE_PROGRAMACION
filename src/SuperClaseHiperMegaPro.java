
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
/**
 * @author Jonnathan Juarez
 * @version 1.0 02/08/2017
 */
public class SuperClaseHiperMegaPro {

    private List<String> alfabeto = new ArrayList<String>();
    private ArrayList<String> operadoresList = new ArrayList<String>(Arrays.asList(".", "|", "*", "+", "?", "^"));
    private static Stack<Automata> stackDeAutomatas = new Stack<>();
    public static int contador = 0;
    //constructor
    public SuperClaseHiperMegaPro() {

    }

    //determina los simbolos que forma en el alfabeto
    public void determinarAlfabeto(String postRegex) {
        char[] simbolos = postRegex.toCharArray();
        for (int i = 0; i < simbolos.length; i++) {
            char letra = simbolos[i];
            if (alfabeto.contains(Character.toString(letra)) == false && operadoresList.contains(Character.toString(letra)) == false) {
                alfabeto.add(Character.toString(letra));
            }
        }
    }

    public List<String> getAlfabeto() {
        return alfabeto;
    }

    //trabajo en progreso
    public String analizadorDeAbreviaturas(String cadenaRegex) {
        String nuevaCadena = "";
        for (int i = 0; i < cadenaRegex.length(); i++) {
            //cambia el simbolo de abreviatura por su valor origina
            if (String.valueOf(cadenaRegex.charAt(i)).equals("+")) {
                nuevaCadena += "(" + String.valueOf(cadenaRegex.charAt(i - 1)) + String.valueOf(cadenaRegex.charAt(i - 1)) + "*)";
            } else if (String.valueOf(cadenaRegex.charAt(i)).equals("?")) {
                nuevaCadena += "(" + String.valueOf(cadenaRegex.charAt(i - 1)) + "|@)";
            } else {
                nuevaCadena += String.valueOf(cadenaRegex.charAt(i));
            }
        }
        return nuevaCadena;
    }
    /**
     * Evalula la expresion y determina que operacion hacer, add or pop del stack y cuantas veces hacerlo
     *
     */
    public Automata analizador(String expresionENPostFix){

        for (int i = 0; i < expresionENPostFix.length(); i++){
            char simboloAct = expresionENPostFix.charAt(i);
//            necesita de dos automatas para proceder
            if (simboloAct == '|' || simboloAct == '.') {
                if (simboloAct == '.'){
//                    extrae los automatas a trabajar
                    Automata b = stackDeAutomatas.pop();
                    alfabeto.toString();
                    Automata a = stackDeAutomatas.pop();
                    Automata resultante = crearConcatenacion(a, b);
                    stackDeAutomatas.add(resultante);
                }
                else if(simboloAct == '|'){
//                    extrae los automatas a trabajar
                    Automata b = stackDeAutomatas.pop();
                    Automata a = stackDeAutomatas.pop();
                    Automata resultante = crearOr(a, b);
                    stackDeAutomatas.add(resultante);

                }
            }
//            solo necesita de un automata
            else if(simboloAct == '*' || simboloAct == '?' || simboloAct == '+'){
                if (simboloAct == '*'){
//                    extrae el automata a trabajar
                    Automata a = stackDeAutomatas.pop();
                    Automata resultante = crearkleen(a);
                    stackDeAutomatas.add(resultante);
                }
//                se esta trabajando en elresto de automatas
            }
//            no hace ningua operacion
            else {
                Automata automata = crearAutomataSimple(String.valueOf(simboloAct));
                stackDeAutomatas.add(automata);
            }
        }
        return stackDeAutomatas.pop();
    }
    public Automata crearAutomataSimple(String simbolo){
        Automata a = new Automata();
        a.addEstado(a,contador,true,false);
        a.addEstado(a,contador+1, false, true);
        a.addTrancion(a,a.getEstadoInicale(),a.getEstadoFinal(),simbolo);
        contador +=2;
        return a;
    }
    public Automata crearConcatenacion(Automata a, Automata b){
        HashSet<Estado> estadosB = b.getEstados();
        HashSet<Trancision> transicoinesB = b.getTransicoines();

//        agregar trancion
        for (Trancision t: transicoinesB){
            if(t.getEstadoInicial().getEsinicial()){
                t.setEstadoInicial(a.getEstadoFinal());
                a.getEstadoFinal().setFinal(false);  // Quitarle propiedad de nodo final al estado Final de A
                a.addTrancion(a, t);  // Agregar a nuevo automata

            }
            else {
                a.addTrancion(a,t);
            }
        }
        //agregando estados de B a A
        for(Estado e: estadosB){
            if(!e.getEsinicial()){
                a.addEstado(a, e);
            }
        }
        return a;
    }
    public Automata crearOr(Automata a, Automata b){
        Estado i = new Estado(true,false,contador);
        Automata Resultamte = new Automata();
        //agrega el nodo de inicio
        Resultamte.addEstado(Resultamte, i);
        //obtener el los estados y transicone de ambos automatas
        HashSet<Estado> estadosA = a.getEstados();
        HashSet<Estado> estadosB = b.getEstados();
        HashSet<Trancision> transA = a.getTransicoines();
        HashSet<Trancision> transB = b.getTransicoines();

        return null;
    }
    public Automata crearkleen(Automata a){
        return null;
    }
}
