public class Trancision {
    private String simbolos;
    private boolean epsilon;

    public Trancision(String simbolos) {
        this.simbolos = simbolos;
    }
    public Trancision(boolean epsilon) {
        this.epsilon = epsilon;
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
