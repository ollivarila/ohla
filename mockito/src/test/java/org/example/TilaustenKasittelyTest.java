package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TilaustenKasittelyTest {

    @Mock
    IHinnoittelija hinnoittelijaMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        reset(hinnoittelijaMock);
    }

    @Test
    public void testExtraDiscount(){
        float initialBalance = 300f;
        float listingPrice = 120f;
        float discount = 20f;
        float finalBalance = initialBalance - (listingPrice * (1 - (discount + 5)/ 100));
        Asiakas customer = new Asiakas(initialBalance);
        Tuote prod = new Tuote("Monitor", listingPrice);

        when(hinnoittelijaMock.getAlennusProsentti(customer, prod)).thenReturn(discount).thenReturn(discount + 5);

        TilaustenKasittely handler =  new TilaustenKasittely();
        handler.setHinnoittelija(hinnoittelijaMock);
        handler.käsittele(new Tilaus(customer, prod));

        assertEquals(finalBalance, customer.getSaldo(), 0.001);
        verify(hinnoittelijaMock).aloita();
        verify(hinnoittelijaMock, times(1)).setAlennusProsentti(customer, discount + 5);
        verify(hinnoittelijaMock, times(2)).getAlennusProsentti(customer, prod);
        verify(hinnoittelijaMock).lopeta();
    }

    @Test
    public void testNormalDiscount(){
        float initialBalance = 300f;
        float listingPrice = 30f;
        float discount = 20f;
        float finalBalance = initialBalance - (listingPrice * (1 - discount / 100));
        Asiakas customer = new Asiakas(initialBalance);
        Tuote prod = new Tuote("Clean code", listingPrice);

        when(hinnoittelijaMock.getAlennusProsentti(customer, prod)).thenReturn(discount);

        TilaustenKasittely handler =  new TilaustenKasittely();
        handler.setHinnoittelija(hinnoittelijaMock);
        handler.käsittele(new Tilaus(customer, prod));

        assertEquals(finalBalance, customer.getSaldo(), 0.001);
        verify(hinnoittelijaMock).aloita();
        verify(hinnoittelijaMock, times(2)).getAlennusProsentti(customer, prod);
        verify(hinnoittelijaMock, times(0)).setAlennusProsentti(customer, discount);
        verify(hinnoittelijaMock).lopeta();
    }

}