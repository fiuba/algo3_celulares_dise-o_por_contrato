package ar.edu.uba.fi;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Minuto> entradas;

    public Registro() {

        entradas = new ArrayList<>();
    }
    public void registrar(Minuto duracion) {

        entradas.add(duracion);
    }

    public Minuto duracionTotal() {

        return entradas.stream().reduce(new Minuto(), (a, b) -> a.sumar(b));
    }
}
