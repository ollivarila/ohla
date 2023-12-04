package kps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValintaTest {

    // Jos voitot toimii niin häviöt toimii myös
    @Test
    void testVoitot(){
        Tulos t1 = Valinta.KIVI.vertaa(Valinta.SAKSET);
        Tulos t2 = Valinta.PAPERI.vertaa(Valinta.KIVI);
        Tulos t3 = Valinta.SAKSET.vertaa(Valinta.PAPERI);
        for (Tulos t : new Tulos[]{t1, t2, t3}) {
            assertEquals(Tulos.VOITTO, t);
        }
    }

    @Test
    void testTasurit(){
        Tulos t1 = Valinta.KIVI.vertaa(Valinta.KIVI);
        Tulos t2 = Valinta.PAPERI.vertaa(Valinta.PAPERI);
        Tulos t3 = Valinta.SAKSET.vertaa(Valinta.SAKSET);
        for (Tulos t : new Tulos[]{t1, t2, t3}) {
            assertEquals(Tulos.TASAN, t);
        }
    }
}