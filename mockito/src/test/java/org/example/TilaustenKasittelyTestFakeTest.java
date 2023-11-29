package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TilaustenKasittelyTestFakeTest {
    @Test
    public void testaaKäsittelijäWithFakeHinnoittelija() {
        float alkuSaldo = 100.0f;
        float listaHinta = 30.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        IHinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);
        TilaustenKasittely käsittelijä = new TilaustenKasittely();
        käsittelijä.setHinnoittelija(hinnoittelija);
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));

        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
    }

}