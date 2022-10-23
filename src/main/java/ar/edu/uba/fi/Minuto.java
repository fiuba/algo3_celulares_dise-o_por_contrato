package ar.edu.uba.fi;

import java.util.ArrayList;

public class Minuto {
    private int valor;

    public Minuto(int valor) {

        this.valor = valor;
    }

    public Minuto() {

        valor = 0;
    }

    public double multiplicarPor(int veces) {

        return valor * veces;
    }

    public Minuto sumar(Minuto b) {

        return new Minuto(valor + b.valor);
    }

    public ArrayList<Minuto> fraccionesDe(int limiteMaximo) {
        ArrayList<Minuto> result = new ArrayList<>();
        int copiaValor = valor;

        for ( var i = copiaValor; i > 0; i = i - limiteMaximo) {
                if ( copiaValor >= limiteMaximo) {
                    result.add(new Minuto(limiteMaximo));

                    copiaValor = copiaValor - limiteMaximo;
                } else {

                    result.add(new Minuto(copiaValor));
                }

        }

        return result;
    }

    public double multiplicarPorSiEsMayorIgualA(int multiplicador, int limiteMaximo) {

        if ( valor >= limiteMaximo) {
            return valor * multiplicador;
        }

        return 0;
    }

    public double multiplicarPorSiEsMenorA(int multiplicador, int limiteMaximo) {
        if ( valor < limiteMaximo) {
            return valor * multiplicador;
        }

        return 0;
    }
}
