public class Trancision {
    private Estado estadoInicial;
    private Estado estadoFinal;
    private String simbolos;
    private boolean epsilon;

    public Trancision() {

    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Estado getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Estado estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(String simbolos) {
        this.simbolos = simbolos;
    }

    public boolean isEpsilon() {
        return epsilon;
    }

    public void setEpsilon(boolean epsilon) {
        this.epsilon = epsilon;
    }
}
