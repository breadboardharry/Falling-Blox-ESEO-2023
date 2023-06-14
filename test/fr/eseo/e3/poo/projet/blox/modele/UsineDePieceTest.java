package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class UsineDePieceTest {

    @Test
    void testMode() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        assertEquals(UsineDePiece.ALEATOIRE_COMPLET, UsineDePiece.getMode(), "Getter et setter mode ALEATOIRE_COMPLET");
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.getMode(), "Getter et setter mode ALEATOIRE_PIECE");
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        assertEquals(UsineDePiece.CYCLIC, UsineDePiece.getMode(), "Getter et setter mode CYCLIC");
    }

    @Test
    void testResetCyclic() {
        // Get the expected pieces and set their position
        List<Piece> excpectedPieces = UsineDePiece.getPiecesArray();
        excpectedPieces.get(0).setPosition(2, 3);
        excpectedPieces.get(1).setPosition(2, 3);

        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        assertEquals(excpectedPieces.get(1), piece2, "Vérifier génération pièce cylic");

        // Change mode and get back to cyclic
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        UsineDePiece.setMode(UsineDePiece.CYCLIC);

        // Third piece should be the first one again
        Piece piece3 = UsineDePiece.genererPiece();
        assertEquals(excpectedPieces.get(0), piece3, "Vérifier réinitialisation du cyclic");
    }

    @Test
    void testGenererPieceAleatoire() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece1 = UsineDePiece.genererPiece();
        assertNotNull(piece1, "Vérifier génération pièce aléatoire");

        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Piece piece2 = UsineDePiece.genererPiece();
        assertNotNull(piece2, "Vérifier génération pièce aléatoire");
    }

    @Test
    void testGenererPieceCycle() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        List<Piece> excpectedPieces = UsineDePiece.getPiecesArray();

        for (int i = 0; i < excpectedPieces.size(); i++) {
            Piece piece = UsineDePiece.genererPiece();
            excpectedPieces.get(i).setPosition(2, 3);
            assertEquals(excpectedPieces.get(i), piece, "Vérifier génération pièce cylic");
        }
    }

    @Test
    void testGenererPieceInvalide() {
        UsineDePiece.setMode(9999);

        try {
            UsineDePiece.genererPiece();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Mode invalide : 9999", e.getMessage(), "Vérifier exception mode invalide");
        }
    }

    @Test
    void testGetPiecesArray() {
        List<Piece> pieces = UsineDePiece.getPiecesArray();
        assertEquals(2, pieces.size(), "Vérifier taille pièces par défaut");
    }

    @Test
    void testGetPiecesArrayWithColor() {
        List<Piece> pieces = UsineDePiece.getPiecesArray(Couleur.CYAN);
        assertEquals(2, pieces.size(), "Vérifier taille pièces avec couleur");
    }

    // Create an array of pieces with a defined size
    private ArrayList<Piece> pieceArray(int nb) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < nb; i++) {
            pieces.add(UsineDePiece.genererPiece());
        }
        return pieces;
    }

    private boolean inInterval(int value, int min, int max) {
        return value >= min && value <= max;
    }

    @Test
    void testGenererPieceAC() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        final ArrayList<Piece> pieces = pieceArray(10000);

        int nbIPiece = 0, nbOPiece = 0;
        for (Object piece : pieces) {
            if (piece instanceof IPiece) nbIPiece++;
            else if (piece instanceof OPiece) nbOPiece++;
        }

        // Check estimation of number of pieces
        assertTrue(inInterval(nbIPiece, 4800, 5200), "Estimation nombre de IPiece [4800 - 5200] @ 10000");
        assertTrue(inInterval(nbOPiece, 4800, 5200), "Estimation nombre de OPiece [4800 - 5200] @ 10000");
    }
}