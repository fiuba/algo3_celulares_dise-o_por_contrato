package ar.edu.uba.fi;

public class iPhone {

    private final double capacidadBateria;
    private double bateriaRestante;


    public iPhone() {

        capacidadBateria = 5;
        bateriaRestante = 5;
    }

    public void llamar(MotoG motoG, Minuto duracion) {
        double valor = duracion.multiplicarVeces(1 /* porcentaje */);

        bateriaRestante = bateriaRestante - (bateriaRestante * valor / 100);

        if (bateriaRestante <0 ) {
            bateriaRestante = 0;
        }
    }

    public double bateria() {
        return bateriaRestante;
    }

    public void cargar() {
        bateriaRestante = capacidadBateria;
    }
}
