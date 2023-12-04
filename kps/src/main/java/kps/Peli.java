package kps;

import java.util.Objects;

/**
 *
 * @author Ira Dook
 */

public class Peli {

    /**
     * Pelaaja 1
     */
    private final Pelaaja p1;
    /**
     * Pelaaja 2
     */
    private final Pelaaja p2;

    public Peli(Pelaaja p1, Pelaaja p2){
        this.p1 = Objects.requireNonNull(p1);
        this.p2 = Objects.requireNonNull(p2);
    }

    /**
     * Pelaa kivi paperi sakset -peliä kunnes
     * toisella pelaajista on kolme voittoa.
     * @return Pelaaja joka voitti
     */
    public Pelaaja pelaaKokoPeli(){
        int pelatutPelit = 1;           // Pelattujen pelien lkm
        int tasapelit = 0;              // Tasapelien lkm

        while(etsiVoittaja(p1, p2) == null){
            tulosta(String.format("Erä: %d =====================%n", pelatutPelit));
            tulosta(String.format("Tasapelien lukumäärä: %d%n", tasapelit));
            Pelaaja kierroksenVoittaja = pelaaKierros();
            if(kierroksenVoittaja == null){
                tasapelit++;
            }
            pelatutPelit++;
        }
        tulosta("KOLME VOITTOA - PELI PÄÄTTYY");
        return etsiVoittaja(p1, p2);
    }

    /**
     * Pelaa yhden kierroksen kivi paperi sakset -peliä.
     * Palauttaa voittajan tai null jos tasapeli.
     * @return kierroksen voittaja tai null jos tasapeli
     */
    public Pelaaja pelaaKierros(){
        Valinta p1Valinta = p1.uusiValinta();
        Valinta p2Valinta = p2.uusiValinta();
        tulosta(String.format("Pelaaja 1: %s \n\t Pelaaja 1:llä koossa %d voittoa", p1Valinta, p1.getVoitot()));
        tulosta(String.format("Pelaaja 2: %s \n\t Pelaaja 2:llä koossa %d voittoa", p2Valinta, p2.getVoitot()));

        // Tulos pelaaja 1. perspektiivistä
        Tulos tulos = p1Valinta.vertaa(p2Valinta);

        switch (tulos) {
            case VOITTO -> {
                tulosta("Pelaaja 1 voittaa");
                p1.incVoitot();
                return p1;
            }
            case HAVIO -> {
                tulosta("Pelaaja 2 voittaa");
                p2.incVoitot();
                return p2;
            }
            case TASAN -> {
                tulosta("\n\t\t\t Tasapeli \n");
                return null;
            }
            default -> throw new IllegalStateException(String.format("Tuntematon tulos %s", tulos));
        }
    }

    /**
     * Selvittää onko toisella pelaajista kolme tai enemmän voittoa.
     * @param p1 Pelaaja
     * @param p2 Pelaaja
     * @return Pelaaja joka voitti pelin tai null jos ei ole voittajaa vielä
     */
    public Pelaaja etsiVoittaja(Pelaaja p1, Pelaaja p2) {
        if(p1.getVoitot() < 3 && p2.getVoitot() < 3) {
            return null;
        }
        return p1.getVoitot() > p2.getVoitot() ? p1 : p2;
    }

    /**
     * Tulostaa viestin stdout.
     * @param viesti tulostettava viesti
     */
    private void tulosta(String viesti){
        System.out.println(viesti);
    }

}
