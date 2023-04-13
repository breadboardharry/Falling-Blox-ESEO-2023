package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPieceTest {

    @Test
    void testConstructeur() {
        OPiece oPiece = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals(4, oPiece.getElements().size(), "Vérifier nombre d'éléments");
    }

    @Test
    void testGetElements() {
        OPiece oPiece = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals(new Element(0, 0, Couleur.BLEU), oPiece.getElements().get(0), "Vérifier élément 1");
        assertEquals(new Element(1, 0, Couleur.BLEU), oPiece.getElements().get(1), "Vérifier élément 1");
        assertEquals(new Element(0, -1, Couleur.BLEU), oPiece.getElements().get(2), "Vérifier élément 1");
        assertEquals(new Element(1, -1, Couleur.BLEU), oPiece.getElements().get(3), "Vérifier élément 1");
    }

    @Test
    void testToString() {
        OPiece oPiece = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
        assertEquals("OPiece :\n" +
                "\t(0, 0) - BLEU\n" +
                "\t(1, 0) - BLEU\n" +
                "\t(0, -1) - BLEU\n" +
                "\t(1, -1) - BLEU\n", oPiece.toString(), "Vérifier toString");
    }
}