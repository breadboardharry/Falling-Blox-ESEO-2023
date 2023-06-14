package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZPieceTest {

    @Test
    void testConstructeur() {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        assertEquals(new Element(0, 0, Couleur.CYAN), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, -1, Couleur.CYAN), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, -1, Couleur.CYAN), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 0, Couleur.CYAN), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.CYAN), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.CYAN), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, 0, Couleur.CYAN), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.CYAN), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.CYAN), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.CYAN), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, 0, Couleur.CYAN), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.CYAN), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerHoraire() throws BloxException {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        piece.tourner(true);
        assertEquals(new Element(0, 0, Couleur.CYAN), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.CYAN), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, -1, Couleur.CYAN), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.CYAN), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        piece.tourner(false);
        assertEquals(new Element(0, 0, Couleur.CYAN), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(-1, 0, Couleur.CYAN), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, 1, Couleur.CYAN), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, -1, Couleur.CYAN), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        ZPiece piece = new ZPiece(new Coordonnees(0, 0), Couleur.CYAN);
        assertEquals("ZPiece :\n" +
                "\t(0, 0) - CYAN\n" +
                "\t(0, -1) - CYAN\n" +
                "\t(-1, -1) - CYAN\n" +
                "\t(1, 0) - CYAN\n", piece.toString(), "Vérifier toString");
    }
}