package ar.edu.uba.fi;

import java.util.ArrayList;

public class Movistar {
    private ArrayList<Mobile> mobiles;

    public Movistar() {

        this.mobiles = new ArrayList<Mobile>();
    }

    public MotoG registrar(MotoG motoG) {

        mobiles.add(motoG);

        return motoG;
    }

    public double recaudacion() {
        //  Sin stream
        //        double result = 0;
        //
        //        for ( Mobile m : mobiles) {
        //            Minuto duracionLlamadas = m.duracionTotalDeLlamadas();
        //
        //            result = result + duracionLlamadas.multiplicarPor(6);
        //
        //        }
        //
        //        return result;

        // Con stream
        return recaudacionConStreams();

    }

    private double recaudacionConStreams() {
        return mobiles.stream()
                .map((mobile) -> mobile.duracionTotalDeLlamadas().multiplicarPor(6))
                .reduce(0.0, (a,b) -> a + b);
    }

}
