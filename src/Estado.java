public class Estado {
    private boolean esDeAceptacion;
    private boolean esInical;
    private int identifiacador;

    public Estado(int identifiacador, boolean esDeAceptacion, boolean esInical) {
        this.identifiacador = identifiacador;
        this.esDeAceptacion = esDeAceptacion;
        this.esInical = esInical;

    }
}
