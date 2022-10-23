package ar.edu.uba.fi;

public class MotoG extends Mobile {

    public MotoG() {

        super(5);
    }

    public void llamar(iPhone iphone, Minuto duracion) {

        llamadas.registrar(duracion);

        consumirBateria();

        iphone.consumirBateria(duracion);
    }

    private void consumirBateria() {

        bateriaRestante = bateriaRestante - 0.25;
    }

}
