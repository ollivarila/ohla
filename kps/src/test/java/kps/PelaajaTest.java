package kps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {

    private static Pelaaja pelaaja;

    @BeforeEach
    public void setup(){
        pelaaja = new Pelaaja();
    }

    @Test
    void testIncVoitot(){
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.incVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    void testUusiValinta(){
        HashMap<Valinta, Integer> counts = new HashMap<>();
        counts.put(Valinta.KIVI, 0);
        counts.put(Valinta.PAPERI, 0);
        counts.put(Valinta.SAKSET, 0);
        for(int i = 0; i < 10000; i++){
            Valinta v = pelaaja.uusiValinta();
            int current = counts.get(v);
            counts.put(v, current + 1);
        }
        assertEquals(3333, counts.get(Valinta.KIVI), 300);
        assertEquals(3333, counts.get(Valinta.PAPERI), 300);
        assertEquals(3333, counts.get(Valinta.SAKSET), 300);
    }


}