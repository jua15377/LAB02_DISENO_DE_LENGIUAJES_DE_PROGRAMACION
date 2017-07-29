public class Estado {
    private boolean esDeAceptacion;
    private boolean esInical;
    private int identifiacador = 0;

    public Estado(boolean esDeAceptacion, boolean esInical) {
        this.esDeAceptacion = esDeAceptacion;
        this.esInical = esInical;

    }

    public boolean isEsDeAceptacion() {
        return esDeAceptacion;
    }

    public void setEsDeAceptacion(boolean esDeAceptacion) {
        this.esDeAceptacion = esDeAceptacion;
    }

    public boolean isEsInical() {
        return esInical;
    }

    public void setEsInical(boolean esInical) {
        this.esInical = esInical;
    }

    public int getIdentifiacador() {
        return identifiacador;
    }

    public void setIdentifiacador(int identifiacador) {
        this.identifiacador = identifiacador;
    }
}
