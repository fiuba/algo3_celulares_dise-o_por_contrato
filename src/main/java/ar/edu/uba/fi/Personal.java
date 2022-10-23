package ar.edu.uba.fi;

import java.util.ArrayList;

public class Personal {
    private ArrayList<Mobile> mobiles;

    public Personal() {

        this.mobiles = new ArrayList<Mobile>();
    }

    public iPhone registrar(iPhone iPhone) {

        mobiles.add(iPhone);

        return iPhone;
    }

    public double recaudacion() {
        double result = 0;

        for ( Mobile m : mobiles) {
            Minuto duracionLlamadas = m.duracionTotalDeLlamadas();

            ArrayList<Minuto> fracciones = duracionLlamadas.fraccionesDe(10);

            result = result + calcularTotalPrecioPorFraccion(fracciones);

        }

        return result;
    }

    private double calcularTotalPrecioPorFraccion(ArrayList<Minuto> fracciones) {
        double result = 0;

        for (Minuto m : fracciones) {
            result = result + m.multiplicarPorSiEsMayorIgualA(7, 10);
            result = result + m.multiplicarPorSiEsMenorA(4, 10);
        }

        return result;
    }
}
