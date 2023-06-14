package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class PuitsTest {

    @Test
    void testConstructeurVide() {
        // Check default constructor
        Puits puits = new Puits();
        assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur(), "Vérifier largeur par défaut");
        assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur(), "Vérifier largeur par défaut");
    }

    @Test
    void testConstructeurLargeurProfondeur() {
        // Check default constructor
        Puits puits = new Puits(10, 15);
        assertEquals(10, puits.getLargeur(), "Vérifier largeur");
        assertEquals(15, puits.getProfondeur(), "Vérifier largeur");
    }

    @Test
    void testConstructeurComplet() {
        Puits puits = new Puits(10, 15, 50, 8);
        assertEquals(10, puits.getLargeur(), "Vérifier largeur");
        assertEquals(15, puits.getProfondeur(), "Vérifier largeur");
    }

    @Test
    void testConstructeurTas() {
        // Check default constructor
        Puits puits = new Puits(10, 15, 0, 0);
        assertEquals(10, puits.getLargeur(), "Vérifier largeur");
        assertEquals(15, puits.getProfondeur(), "Vérifier largeur");
        assertNotNull(puits.getTas(), "Vérifier tas");
    }

    @Test
    void testGetTas() {
        Puits puits = new Puits(10, 15, 40, 5);
        assertEquals(40, getNbElements(puits.getTas()), "Vérifier tas");
    }

    @Test
    void testGravite() {
        Puits puits = new Puits(12, 15);
        OPiece piece1 = new OPiece(new Coordonnees(2, 2), Couleur.ORANGE);
        OPiece piece2 = new OPiece(new Coordonnees(2, 2), Couleur.ORANGE);
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);

        Tas tas = new Tas(puits, 0, 0);
        puits.setTas(tas);

        // Make the piece fall
        for (int i = 0; i < 19; i++) puits.gravite();

        // Check if the piece has fallen
        assertNotNull(tas.getElements()[puits.getProfondeur()-1]);
    }

    private int getNbElements(Tas tas) {
        Element[][] elements = tas.getElements();
        int nbElements = 0;

        // Get the total number of instanced elements in the two-dimensional array
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != null) nbElements++;
            }
        }
        return nbElements;
    }

    @Test
    void testSetLargeur() {
        Puits puits = new Puits(10, 24);
        puits.setLargeur(12);
        assertEquals(12, puits.getLargeur(), "Vérifier setter largeur");
    }

    @Test
    void testSetLargeurInvalide() {
        // Check constructor with invalid width (< 5)
        try {
            Puits puits = new Puits(0, 20);
            fail("Vérifier largeur invalide");
        } catch (IllegalArgumentException e) {
            assertEquals("Largeur invalide : 0 (5 - 15)", e.getMessage());
        }

        // Check constructor with invalid width (> 15)
        try {
            Puits puits = new Puits(20, 20);
            fail("Vérifier largeur invalide");
        } catch (IllegalArgumentException e) {
            assertEquals("Largeur invalide : 20 (5 - 15)", e.getMessage());
        }
    }

    @Test
    void testGetLargeur() {
        Puits puits = new Puits(12, 24);
        assertEquals(12, puits.getLargeur(), "Vérifier getter largeur");
    }

    @Test
    void testSetProfondeur() {
        Puits puits = new Puits(12, 20);
        puits.setProfondeur(24);
        assertEquals(24, puits.getProfondeur(), "Vérifier setter profondeur");
    }

    @Test
    void testSetProfondeurInvalide() {
        // Check constructor with invalid depth (< 15)
        try {
            Puits puits = new Puits(10, 0);
            fail("Vérifier profondeur invalide");
        } catch (IllegalArgumentException e) {
            assertEquals("Profondeur invalide : 0 (15 - 25)", e.getMessage());
        }

        // Check constructor with invalid depth (> 25)
        try {
            Puits puits = new Puits(10, 50);
            fail("Vérifier profondeur invalide");
        } catch (IllegalArgumentException e) {
            assertEquals("Profondeur invalide : 50 (15 - 25)", e.getMessage());
        }
    }

    @Test
    void testGetProfondeur() {
        Puits puits = new Puits(12, 24);
        assertEquals(24, puits.getProfondeur(), "Vérifier getter profondeur");
    }

    @Test
    void testGetPieceActuelle() {
        Puits puits = new Puits();
        OPiece piece1 = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
        OPiece piece2 = new OPiece(new Coordonnees(1, 3), Couleur.ROUGE);
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);
        assertEquals(piece1, puits.getPieceActuelle(), "Vérifier getter pièce actuelle");
    }

    @Test
    void testPieceSuivante() {
        Puits puits = new Puits();

        OPiece piece1 = new OPiece(new Coordonnees(0, 0), Couleur.BLEU);
        puits.setPieceSuivante(piece1);
        assertEquals(piece1, puits.getPieceSuivante(), "Vérifier setter pièce suivante");

        IPiece piece2 = new IPiece(new Coordonnees(2, 2), Couleur.ROUGE);
        puits.setPieceSuivante(piece2);
        assertEquals(piece2, puits.getPieceSuivante(), "Vérifier setter pièce suivante");
    }

    @Test
    void testToString() {
        Puits puits = new Puits();
        assertEquals("Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\n" +
                "Piece Actuelle : <aucune>\n" +
                "Piece Suivante : <aucune>\n", puits.toString(), "Vérifier toString vide");

        puits.setPieceSuivante(new OPiece(new Coordonnees(0, 0), Couleur.BLEU));
        assertEquals("Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\n" +
                "Piece Actuelle : <aucune>\n" +
                "Piece Suivante : OPiece :\n" +
                "\t(0, 0) - BLEU\n" +
                "\t(1, 0) - BLEU\n" +
                "\t(0, -1) - BLEU\n" +
                "\t(1, -1) - BLEU\n", puits.toString(), "Vérifier toString piece suivante");

        puits.setPieceSuivante(new IPiece(new Coordonnees(0, 0), Couleur.ROUGE));
        assertEquals("Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\n" +
                "Piece Actuelle : OPiece :\n" +
                "\t(5, -4) - BLEU\n" +
                "\t(6, -4) - BLEU\n" +
                "\t(5, -5) - BLEU\n" +
                "\t(6, -5) - BLEU\n" +
                "Piece Suivante : IPiece :\n" +
                "\t(0, 0) - ROUGE\n" +
                "\t(0, -2) - ROUGE\n" +
                "\t(0, -1) - ROUGE\n" +
                "\t(0, 1) - ROUGE\n", puits.toString(), "Vérifier toString piece suivante");
    }
}