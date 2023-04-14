package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VuePuitsTest {

    @Test
    void testConstructeur() {
        VuePuits vue1 = new VuePuits(new Puits());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vue1.getTaille(), "Vérifier taille par défaut");

        VuePuits vue2 = new VuePuits(new Puits(), 10);
        assertEquals(10, vue2.getTaille(), "Vérifier taille fournie");
    }

    @Test
    void testGetPuits() {
        Puits puits = new Puits();
        VuePuits vue = new VuePuits(puits);
        assertEquals(puits, vue.getPuits(), "Vérifier getter puits");
    }

    @Test
    void testSetPuits() {
        VuePuits vue = new VuePuits(new Puits());
        Puits puits = new Puits();
        vue.setPuits(puits);
        assertEquals(puits, vue.getPuits(), "Vérifier setter puits");
    }

    @Test
    void testGetTaille() {
        VuePuits vue = new VuePuits(new Puits());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vue.getTaille(), "Vérifier getter taille");
    }

    @Test
    void testSetTaille() {
        VuePuits vue = new VuePuits(new Puits());
        vue.setTaille(10);
        assertEquals(10, vue.getTaille(), "Vérifier setter taille");
    }
}