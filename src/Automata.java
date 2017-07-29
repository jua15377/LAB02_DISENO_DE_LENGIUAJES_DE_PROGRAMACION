import java.util.ArrayList;

public class Automata {
    private ArrayList<Trancision> transiciones = new ArrayList<Trancision>();
    private ArrayList<Estado> estadoOrigen = new ArrayList<Estado>();
    private ArrayList<Estado> estadoFinal = new ArrayList<Estado>();


    public Automata(String cadenaDeTransicion){
        Estado estInicial = new Estado(false, true);
        Estado estFinal = new Estado(true,false);
        Trancision  transicion = new Trancision(cadenaDeTransicion);
        this.transiciones.add(transicion);
        this.estadoOrigen.add(estInicial);
        this.estadoFinal.add(estFinal);
    }
    public Automata(Automata a, Automata b){
        Estado ei = new Estado(false, true);
        Trancision t = new Trancision(a.transiciones.get(0).getSimbolos());
        this.transiciones.add(t);
        this.estadoOrigen.add(ei);
        Estado eF = new Estado(true,false);
        this.estadoFinal.add(eF);
        for (int i = 1; i< a.getTransiciones().size();i++){
            this.transiciones.add(a.getTransiciones().get(i));
            this.estadoOrigen.add(a.getEstadoOrigen().get(i));
            this.estadoFinal.add(a.getEstadoFinal().get(i));
        }
        for (int i = 0; i< a.getTransiciones().size();i++){
            this.transiciones.add(b.getTransiciones().get(i));
            this.estadoOrigen.add(b.getEstadoOrigen().get(i));
            this.estadoFinal.add(b.getEstadoFinal().get(i));
        }
    }

    public ArrayList<Trancision> getTransiciones() {
        return transiciones;
    }
    //clase para testear

    public ArrayList<Estado> getEstadoOrigen() {
        return estadoOrigen;
    }
    public ArrayList<Estado> getEstadoFinal() {
        return estadoFinal;
    }
    public void numeraEstados(){

    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i< transiciones.size();i++){
            cadena += "(" + String.valueOf(estadoOrigen.get(i).getIdentifiacador())+", "+ transiciones.get(i).getSimbolos() +", "+ String.valueOf(estadoFinal.get(i).getIdentifiacador()) +")";
        }
        return cadena;
    }
}
