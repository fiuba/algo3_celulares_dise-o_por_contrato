package ar.edu.uba.fi;

public class Mobile {
    private double capacidadBateria;
    protected double bateriaRestante;

    protected Registro llamadas;

    public Mobile(double capacidadBateria) {

        this.capacidadBateria = capacidadBateria;
        this.bateriaRestante = capacidadBateria;
        this.llamadas = new Registro();

    }

    public double bateria() {

        return bateriaRestante;
    }

    public void recargar() {

        bateriaRestante = capacidadBateria;
    }

    protected boolean estaApagado() {

        return bateriaRestante == 0;
    }

    public Minuto duracionTotalDeLlamadas() {
        return llamadas.duracionTotal();
    }

}
