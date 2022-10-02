package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLlamadas {

    @Test
    public void motoGllamaIPhoneDurante1min() {
        MotoG motoG = new MotoG();
        iPhone iphone = new iPhone();

        motoG.llamar(iphone, new Minuto(1));

        assertEquals((5 - 0.25), motoG.bateria());
        assertEquals((5.0 - (5.0 * 1.0 / 100.0)), iphone.bateria());
    }

    @Test
    public void motoGllamaIPhoneDurante5min() {
        MotoG motoG = new MotoG();
        iPhone iphone = new iPhone();

        motoG.llamar(iphone, new Minuto(5));

        assertEquals((5 - 0.25), motoG.bateria());
        assertEquals((5.0 - (5.0 * 5.0 /* duracion */ / 100.0)), iphone.bateria());
    }

    @Test
    public void motoGllamaIPhoneDuranteXminYSeAgotaLaBateria() {
        MotoG motoG = new MotoG();
        iPhone iphone = new iPhone();

        motoG.llamar(iphone, new Minuto(120));

        assertEquals(0, iphone.bateria());
    }

    @Test
    public void motoGllamaIPhoneDuranteXminYSeAgotaLaBateriaLaRecargoYLaCargaEsFull() {
        MotoG motoG = new MotoG();
        iPhone iphone = new iPhone();

        motoG.llamar(iphone, new Minuto(120));

        motoG.cargar();
        iphone.cargar();

        assertEquals(5, motoG.bateria());
        assertEquals(5, iphone.bateria());

    }
}
