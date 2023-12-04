package kps;

public class Main {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli(p1, p2);
        peli.pelaaKokoPeli();
    }
}
