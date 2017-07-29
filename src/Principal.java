import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Principal {
    public static void main(String args[]){

        Scanner teclado = new Scanner(System.in);
        SuperClaseHiperMegaPro unaClase = new SuperClaseHiperMegaPro();
        String entrada;
        Stack<Automata> stackDeAutomatas = new Stack<>();
        //PEDIR REGEX AL USUARIO
        System.out.println("Ingrese la expresion regular del automata");
        entrada = teclado.nextLine();
        String fin = RegExConverter.infixToPostfix(entrada);
        System.out.println(fin);
        unaClase.determinarAlfabeto(fin);
        //devuelve el alfabeto
        System.out.println("alfabeto");
        System.out.println(unaClase.getAlfabeto());
        System.out.println("transiciones de automatas fundamentales");
        for (int i = 0; i< fin.length();i++) {
            if (String.valueOf(fin.charAt(i)).equals(".") == true){
                if (stackDeAutomatas.size()>=2){
                    //obtiene los valores anteriores
                    Automata b = stackDeAutomatas.pop();
                    Automata a = stackDeAutomatas.pop();
                    //ingresa el resultado al stack
                    //stackDeAutomatas.push(unaClase.concatenacion(a,b));
                }
            }
            else{
                stackDeAutomatas.push(unaClase.creatAutomata(String.valueOf(fin.charAt(i))));
            }
        }
        Automata a = stackDeAutomatas.pop();
        System.out.println(a.toString());
    }
}
