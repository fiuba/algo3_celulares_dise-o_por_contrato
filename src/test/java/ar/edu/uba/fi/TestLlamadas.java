package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        motoG.recargar();
        iphone.recargar();

        assertEquals(5, motoG.bateria());
        assertEquals(5, iphone.bateria());

    }

    /* Saber si Paola tiene el celular apagado. */
    @Test
    public void comprobarQueElCeluDePaolaEstaApagadoYAlLlamarArrojaUnError() {
        MotoG motoG = new MotoG();
        iPhone iphone = new iPhone();

        motoG.llamar(iphone, new Minuto(120));

        // isABC() : true
        // - Seguramente tengamos un if (no es cierto con streams)
        // - Potencialmente compromete Tell don't ask.
        // - Es un método creado solo para satisfacer la prueba.

        assertThrows(MobilSinBateria.class, () -> {
            iphone.llamar(motoG, new Minuto(5));
        });
    }

    @Test
    public void paolaConMovistarLlamaMarianaConPersonalSuFacturaEsDeX() {
        Movistar m = new Movistar();
        Personal p = new Personal();

        MotoG motoG = m.registrar(new MotoG());     // Paola - Movistar
        iPhone iphone = p.registrar(new iPhone());  // Mariana - Personal

        motoG.llamar(iphone, new Minuto(3));

        assertEquals(18.0, m.recaudacion());
        assertEquals(0.0, p.recaudacion());


    }
    @Test
    public void marianaConPersonalLlamaPaolaMovistarDurante10MinutosSuFacturaEsDeX() {
        Movistar m = new Movistar();
        Personal p = new Personal();

        MotoG motoG = m.registrar(new MotoG());     // Paola - Movistar
        iPhone iphone = p.registrar(new iPhone());  // Mariana - Personal

        iphone.llamar(motoG, new Minuto(10));

        assertEquals(0.0, m.recaudacion());
        assertEquals(70.0, p.recaudacion());


    }

    @Test
    public void marianaConPersonalLlamaPaolaMovistarDuranteMasDe10MinutosSuFacturaEsDeX() {
        Movistar m = new Movistar();
        Personal p = new Personal();

        MotoG motoG = m.registrar(new MotoG());     // Paola - Movistar
        iPhone iphone = p.registrar(new iPhone());  // Mariana - Personal

        iphone.llamar(motoG, new Minuto(12));

        assertEquals(0.0, m.recaudacion());
        assertEquals(78.0, p.recaudacion());


    }
}
