package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPieceTest {

    @Test
    void testConstructeur() {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        assertEquals(new Element(0, 0, Couleur.VIOLET), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, -1, Couleur.VIOLET), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, -1, Couleur.VIOLET), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(-1, 0, Couleur.VIOLET), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.VIOLET), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.VIOLET), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(2, 0, Couleur.VIOLET), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.VIOLET), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.VIOLET), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.VIOLET), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(2, 0, Couleur.VIOLET), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.VIOLET), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerHoraire() throws BloxException {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        piece.tourner(true);
        assertEquals(new Element(0, 0, Couleur.VIOLET), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.VIOLET), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 1, Couleur.VIOLET), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, -1, Couleur.VIOLET), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        piece.tourner(false);
        assertEquals(new Element(0, 0, Couleur.VIOLET), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(-1, 0, Couleur.VIOLET), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, -1, Couleur.VIOLET), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.VIOLET), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VIOLET);
        assertEquals("SPiece :\n" +
                "\t(0, 0) - VIOLET\n" +
                "\t(0, -1) - VIOLET\n" +
                "\t(1, -1) - VIOLET\n" +
                "\t(-1, 0) - VIOLET\n", piece.toString(), "Vérifier toString");
    }
}