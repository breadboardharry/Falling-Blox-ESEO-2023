package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class OPieceTest {

    @Test
    void testConstructeur() {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals(4, piece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals(new Element(0, 0, Couleur.ROUGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.ROUGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(0, -1, Couleur.ROUGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(1, -1, Couleur.ROUGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testSetPosition() {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        piece.setPosition(1, 1);
        assertEquals(new Element(1, 1, Couleur.ROUGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(2, 1, Couleur.ROUGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.ROUGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 0, Couleur.ROUGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testPuits() {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits(), "Vérifier puits");
    }

    @Test
    void testDeplacerDe() throws BloxException {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        piece.deplacerDe(1, 1);
        assertEquals(new Element(1, 1, Couleur.ROUGE), piece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(2, 1, Couleur.ROUGE), piece.getElements().get(1), "Vérifier élément 2");
        assertEquals(new Element(1, 0, Couleur.ROUGE), piece.getElements().get(2), "Vérifier élément 3");
        assertEquals(new Element(2, 0, Couleur.ROUGE), piece.getElements().get(3), "Vérifier élément 4");
    }

    @Test
    void testDeplacerDeIncorrect() throws BloxException {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
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
    void testToString() {
        OPiece piece = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals("OPiece :\n" +
                "\t(0, 0) - ROUGE\n" +
                "\t(1, 0) - ROUGE\n" +
                "\t(0, -1) - ROUGE\n" +
                "\t(1, -1) - ROUGE\n", piece.toString(), "Vérifier toString");
    }
}