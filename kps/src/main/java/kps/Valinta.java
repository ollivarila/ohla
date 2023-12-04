package kps;

public enum Valinta {
    KIVI(0, 2), // Kiven arvo 0 ja voittaa sakset jne.
    PAPERI(1, 0),
    SAKSET(2, 1);

    /**
     * Kyseisen valinnan sisäinen arvo, käytetään vertaamiseen.
     */
    private final int arvo;

    /**
     * Mitä arvoa vastaan kyseinen valinta voittaa.
     */
    private final int voittaa;
    Valinta(int arvo, int voittaa) {
        this.arvo = arvo;
        this.voittaa = voittaa;
    }

    /**
     * Vertaa kahta valintaa toisiinsa ja kertoo tuloksen.
     * Toimii vähän samalla idealla kuin Comparable rajapinta.
     * @see Comparable
     * @param v verrattava valinta
     * @return vertauksen tulos
     */
    public Tulos vertaa(Valinta v){
        if(this.voittaa == v.arvo){
            return Tulos.VOITTO;
        }
        if(this.arvo == v.arvo){
            return Tulos.TASAN;
        }
        return Tulos.HAVIO;
    }

}
