package ar.edu.uba.fi;

public class Minuto {
    private int valor;

    public Minuto(int valor) {

        this.valor = valor;
    }

    public double multiplicarVeces(int veces) {
        return valor * veces;
    }
}
