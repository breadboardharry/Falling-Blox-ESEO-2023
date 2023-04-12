package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordonneesTest {

    @Test
    void testConstructeur() {
        Coordonnees c1 = new Coordonnees(1, 2);
        Coordonnees c2 = new Coordonnees(1, 2);
        assertEquals(c1, c2, "Deux mêmes coordonnées");
    }

    @Test
    void getAbscisse() {
        Coordonnees c = new Coordonnees(1, 2);
        assertEquals(1, c.getAbscisse(), "GetAbscisse");
    }

    @Test
    void testSetAbscisse() {
        Coordonnees c = new Coordonnees(0, 2);
        c.setAbscisse(1);
        assertEquals(1, c.getAbscisse(), "SetAbscisse");
    }

    @Test
    void testGetOrdonnee() {
        Coordonnees c = new Coordonnees(1, 2);
        assertEquals(2, c.getOrdonnee(), "GetOrdonnee");
    }

    @Test
    void testSetOrdonnee() {
        Coordonnees c = new Coordonnees(1, 0);
        c.setOrdonnee(2);
        assertEquals(2, c.getOrdonnee(), "SetOrdonnee");
    }

    @Test
    void testSetCoordonnees() {
        Coordonnees c = new Coordonnees(0, 0);
        c.setCoordonnees(1, 2);
        assertEquals(1, c.getAbscisse(), "SetCoordonnees abscisse");
        assertEquals(2, c.getOrdonnee() , "SetCoordonnees ordonnee");
    }

    @Test
    void testToString() {
        Coordonnees c = new Coordonnees(1, 2);
        assertEquals("(1, 2)", c.toString(), "ToString");
    }

    @Test
    void testEquals() {
        Coordonnees c1 = new Coordonnees(1, 2);
        Coordonnees c2 = new Coordonnees(1, 2);
        Coordonnees c3 = new Coordonnees(2, 1);
        assertEquals(true, c1.equals(c2), "Deux coordonnées identiques");
        assertEquals(false, c1.equals(c3), "Deux coordonnées différentes");
    }
}