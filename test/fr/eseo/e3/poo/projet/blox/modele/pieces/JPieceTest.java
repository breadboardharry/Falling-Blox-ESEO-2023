package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPieceTest {

    @Test
    void testConstructeur() {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        assertEquals(new Element(0, 0, Couleur.JAUNE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, -2, Couleur.JAUNE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, -1, Couleur.JAUNE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(-1, 0, Couleur.JAUNE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.JAUNE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.JAUNE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.JAUNE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.JAUNE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.JAUNE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.JAUNE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.JAUNE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.JAUNE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerHoraire() throws BloxException {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.tourner(true);
        assertEquals(new Element(0, 0, Couleur.JAUNE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(2, 0, Couleur.JAUNE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.JAUNE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, -1, Couleur.JAUNE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.tourner(false);
        assertEquals(new Element(0, 0, Couleur.JAUNE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(-2, 0, Couleur.JAUNE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, 0, Couleur.JAUNE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.JAUNE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        JPiece piece = new JPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        assertEquals("JPiece :\n" +
                "\t(0, 0) - JAUNE\n" +
                "\t(0, -2) - JAUNE\n" +
                "\t(0, -1) - JAUNE\n" +
                "\t(-1, 0) - JAUNE\n", piece.toString(), "Vérifier toString");
    }
}