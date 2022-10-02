package ar.edu.uba.fi;

import java.util.Scanner;

public class MotoG {

    private final double capacidadBateria;
    private double bateriaRestante;

    public MotoG() {

        capacidadBateria = 5;
        bateriaRestante = 5;
    }

    public void llamar(iPhone iphone, Minuto duracion) {
        bateriaRestante = bateriaRestante - 0.25;
        iphone.llamar(this, duracion);
    }

    public double bateria() {
        return bateriaRestante;
    }

    public void cargar() {
        bateriaRestante = capacidadBateria;
    }
}
