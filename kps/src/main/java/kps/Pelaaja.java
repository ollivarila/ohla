package kps;

import java.util.Random;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    /**
     * Voittojen lukumäärä
     */
    private int voitot;

    /**
     * Kaikki mahdolliset valinnat
     */
    private static final Valinta[] kps = {Valinta.KIVI, Valinta.PAPERI, Valinta.SAKSET};

    /**
     * Satunnaislukugeneraattori valintoja varten
     */
    private static final Random gen = new Random();


    /**
     * Valitsee satunnaisesti kivi, paperi tai sakset.
     * @return kivi, paperi tai sakset valinta
     */
    public Valinta uusiValinta() {
        int c = gen.nextInt(0, 3);
        return kps[c];
    }

    /**
     * Kasvattaa kyseisen pelaajan voittojen määrää yhdellä.
     */
    public void incVoitot(){
        this.voitot++;
    }

    public int getVoitot() {
        return voitot;
    }
}
