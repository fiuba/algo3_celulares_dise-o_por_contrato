package ar.edu.uba.fi;

import java.util.ArrayList;

public class iPhone extends Mobile {


    public iPhone() {

        super(5);
    }

    public void llamar(MotoG motoG, Minuto duracion) {

        if (estaApagado()) {

            throw new MobilSinBateria();
        }

        llamadas.registrar(duracion);

    }

    public void consumirBateria(Minuto duracion) {
        double valor = duracion.multiplicarPor(1 /* porcentaje */);

        bateriaRestante = bateriaRestante - (bateriaRestante * valor / 100);

        if (bateriaRestante < 0) {
            bateriaRestante = 0;
        }

    }
}
