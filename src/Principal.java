import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){

        Scanner teclado = new Scanner(System.in);
        SuperClaseHiperMegaPro unaClase = new SuperClaseHiperMegaPro();
        String entrada;
        System.out.println("Ingrese la expresion regular del automata");
        entrada = teclado.nextLine();
        String fin = RegExConverter.infixToPostfix(entrada);
        System.out.println(fin);
        unaClase.determinarAlfabeto(fin);
        //devuelve el alfabeto
        System.out.println(unaClase.getAlfabeto());
        
    }
}
