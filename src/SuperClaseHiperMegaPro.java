import java.lang.reflect.Array;
import java.util.*;

public class SuperClaseHiperMegaPro {

    private List<String> alfabeto = new ArrayList<String>();
    private ArrayList<String> operadoresList = new ArrayList<String>(Arrays.asList(".", "|", "*", "+", "?", "^"));

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
}
