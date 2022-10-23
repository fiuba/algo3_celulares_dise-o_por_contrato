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

        // NOTA: Utilizar streams en este código puede resultar en un código criptico.
        for ( Mobile mobile : mobiles) {
            Minuto duracionLlamadas = mobile.duracionTotalDeLlamadas();

            ArrayList<Minuto> fracciones = duracionLlamadas.fraccionesDe(10);

            for (Minuto m : fracciones) {
                result = result + m.multiplicarPorSiEsMayorIgualA(7, 10);
                result = result + m.multiplicarPorSiEsMenorA(4, 10);
            }

        }

        return result;
    }
}
