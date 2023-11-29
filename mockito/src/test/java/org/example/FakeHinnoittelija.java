package org.example;

public class FakeHinnoittelija implements IHinnoittelija {
    private final float alennus;
    public FakeHinnoittelija(float alennus) {
        this.alennus = alennus;
    }
    public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
        return alennus;
    }

    @Override
    public void aloita() {
        System.out.println("aloita");
    }

    @Override
    public void setAlennusProsentti(Asiakas asiakas, float v) {
    }

    @Override
    public void lopeta() {
        System.out.println("lopeta");
    }

}
