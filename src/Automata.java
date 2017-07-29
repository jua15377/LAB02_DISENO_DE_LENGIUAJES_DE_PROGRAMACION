import java.util.ArrayList;

public class Automata {
    private ArrayList<Trancision> transicones;
    private ArrayList<Estado> estadoOrigen;
    private ArrayList<Estado> estadoFinal;
    public Automata(String cadenaDeTransicion){

    }
    public Estado getEstadoInicial(){
        return estados.get(0);
    }
    public Estado getEstadoFinal(){
        return estados.get(estados.size()-1);
    }
}
