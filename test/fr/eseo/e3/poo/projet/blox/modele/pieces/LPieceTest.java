package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LPieceTest {

    @Test
    void testConstructeur() {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        assertEquals(new Element(0, 0, Couleur.VERT), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, -2, Couleur.VERT), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, -1, Couleur.VERT), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 0, Couleur.VERT), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.VERT), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.VERT), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.VERT), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.VERT), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.VERT), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.VERT), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.VERT), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.VERT), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerHoraire() throws BloxException {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        piece.tourner(true);
        assertEquals(new Element(0, 0, Couleur.VERT), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(2, 0, Couleur.VERT), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.VERT), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.VERT), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        piece.tourner(false);
        assertEquals(new Element(0, 0, Couleur.VERT), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(-2, 0, Couleur.VERT), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, 0, Couleur.VERT), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, -1, Couleur.VERT), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.VERT);
        assertEquals("LPiece :\n" +
                "\t(0, 0) - VERT\n" +
                "\t(0, -2) - VERT\n" +
                "\t(0, -1) - VERT\n" +
                "\t(1, 0) - VERT\n", piece.toString(), "Vérifier toString");
    }
}