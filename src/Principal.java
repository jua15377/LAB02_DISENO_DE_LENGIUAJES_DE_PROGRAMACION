import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jonnathan Juarez
 * @version 1.0 02/08/2017
 */
public class Principal {
    public static void main(String args[]) {
//lee la cadena que contiene la exprexion regular
        Scanner teclado = new Scanner(System.in);
        SuperClaseHiperMegaPro unaClase = new SuperClaseHiperMegaPro();
        String entrada;


        //PEDIR REGEX AL USUARIO
        System.out.println("Ingrese la expresion regular del automata");
        entrada = teclado.nextLine();
        String expresionPostfix = RegExConverter.infixToPostfix(entrada);
        System.out.println(expresionPostfix);
        unaClase.determinarAlfabeto(expresionPostfix);

        //devuelve el alfabeto
        System.out.println("alfabeto");
        System.out.println(unaClase.getAlfabeto());
        System.out.println("concatenacion");
        Automata afn = unaClase.analizador(expresionPostfix);
        System.out.println(afn.toString());
        HashSet<Trancision> trans =  afn.getTransicoines();
        for(Trancision i : trans){
            System.out.println(i.toString());
        }

    }
}
