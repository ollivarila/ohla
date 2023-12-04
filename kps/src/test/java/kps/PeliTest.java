package kps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PeliTest {

    @Test
    void testEtsiVoittajaP1(){
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli(p1, p2);
        Pelaaja pelaaja = peli.etsiVoittaja(p1, p2);
        assertNull(pelaaja);
        p1.incVoitot();
        p1.incVoitot();
        p1.incVoitot();
        Pelaaja tulos = peli.etsiVoittaja(p1, p2);
        assertNotNull(tulos);
        assertEquals(3, tulos.getVoitot());
    }

    @Test
    void testEtsiVoittajaP2(){
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli(p1, p2);
        Pelaaja pelaaja = peli.etsiVoittaja(p1, p2);
        assertNull(pelaaja);
        p2.incVoitot();
        p2.incVoitot();
        p2.incVoitot();
        Pelaaja tulos = peli.etsiVoittaja(p1, p2);
        assertNotNull(tulos);
        assertEquals(3, tulos.getVoitot());
    }

    @Test
    void testPelaaKierrosVoitto() {
        Pelaaja p1 = luoPelaajaMock(Valinta.KIVI, 1);
        Pelaaja p2 = luoPelaajaMock(Valinta.SAKSET, 0);
        Peli peli = new Peli(p1, p2);

        Pelaaja voittaja = peli.pelaaKierros();

        assertNotNull(voittaja);
        verify(p1).incVoitot();
        verify(p1).uusiValinta();
        verify(p2).uusiValinta();
        assertEquals(1, voittaja.getVoitot());
    }

    @Test
    void testPelaaKierrosTasan() {
        Pelaaja p1 = luoPelaajaMock(Valinta.KIVI, 0);
        Pelaaja p2 = luoPelaajaMock(Valinta.KIVI, 0);
        Peli peli = new Peli(p1, p2);

        Pelaaja voittaja = peli.pelaaKierros();

        assertNull(voittaja);
        verify(p1, times(0)).incVoitot();
        verify(p2, times(0)).incVoitot();
        verify(p1).uusiValinta();
        verify(p2).uusiValinta();
    }

    @Test
    void testPelaaKokoPeli(){
        Pelaaja p1 = luoPelaajaMock(Valinta.SAKSET, 2);
        Pelaaja p2 = luoPelaajaMock(Valinta.KIVI, 0);

        // Palauta 6 voittoa yhden kierroksen jälkeen
        when(p1.getVoitot()).thenReturn(2).thenReturn(6);

        Peli peli = new Peli(p1, p2);
        Pelaaja voittaja = peli.pelaaKokoPeli();

        assertEquals(6, voittaja.getVoitot());
    }

    private Pelaaja luoPelaajaMock(Valinta valinta, int voitot){
        Pelaaja pelaaja = mock(Pelaaja.class);
        when(pelaaja.getVoitot()).thenReturn(voitot);
        when(pelaaja.uusiValinta()).thenReturn(valinta);
        return pelaaja;
    }

}