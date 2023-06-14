package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TPieceTest {

    @Test
    void testConstructeur() {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals(new Element(0, 0, Couleur.BLEU), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, +1, Couleur.BLEU), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(-1, 0, Couleur.BLEU), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 0, Couleur.BLEU), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.BLEU), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 2, Couleur.BLEU), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, 1, Couleur.BLEU), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.BLEU), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.BLEU), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 2, Couleur.BLEU), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, 1, Couleur.BLEU), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 1, Couleur.BLEU), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerHoraire() throws BloxException {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.tourner(true);
        assertEquals(new Element(0, 0, Couleur.BLEU), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(-1, 0, Couleur.BLEU), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, -1, Couleur.BLEU), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.BLEU), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.tourner(false);
        assertEquals(new Element(0, 0, Couleur.BLEU), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(+1, 0, Couleur.BLEU), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, 1, Couleur.BLEU), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, -1, Couleur.BLEU), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        TPiece piece = new TPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals("TPiece :\n" +
                "\t(0, 0) - BLEU\n" +
                "\t(0, 1) - BLEU\n" +
                "\t(-1, 0) - BLEU\n" +
                "\t(1, 0) - BLEU\n", piece.toString(), "Vérifier toString");
    }
}