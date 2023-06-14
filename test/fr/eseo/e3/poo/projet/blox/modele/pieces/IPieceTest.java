package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IPieceTest {

    @Test
    void testConstructeur() {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        assertEquals(new Element(0, 0, Couleur.ORANGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(0, -2, Couleur.ORANGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, -1, Couleur.ORANGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(0, 1, Couleur.ORANGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.ORANGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.ORANGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.ORANGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 2, Couleur.ORANGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.ORANGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.ORANGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.ORANGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 2, Couleur.ORANGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testDeplacerDeIncorrect() throws BloxException {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.BLEU);
        try {
            piece.deplacerDe(2, 1);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals(
                    "Delta X must be between -1 and 1 and Delta Y must be between 0 and 1",
                    e.getMessage(),
                    "Vérifier exception"
            );
        }
    }

    @Test
    void testTournerHoraire() throws BloxException {
        IPiece piece = new IPiece(new Coordonnees(2, 2), Couleur.ORANGE);
        piece.tourner(true);
        assertEquals(new Element(2, 2, Couleur.ORANGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(4, 2, Couleur.ORANGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(3, 2, Couleur.ORANGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, 2, Couleur.ORANGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testTournerAntiHoraire() throws BloxException {
        IPiece piece = new IPiece(new Coordonnees(3, 3), Couleur.ORANGE);
        piece.tourner(false);
        assertEquals(new Element(3, 3, Couleur.ORANGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 3, Couleur.ORANGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(2, 3, Couleur.ORANGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(4, 3, Couleur.ORANGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testToString() {
        IPiece piece = new IPiece(new Coordonnees(0, 0), Couleur.ORANGE);
        assertEquals("IPiece :\n" +
                "\t(0, 0) - ORANGE\n" +
                "\t(0, -2) - ORANGE\n" +
                "\t(0, -1) - ORANGE\n" +
                "\t(0, 1) - ORANGE\n", piece.toString(), "Vérifier toString");
    }
}