package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsineDePieceTest {

    @Test
    void testMode() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.getMode(), "Vérifier getter et setter mode");
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
    void testGetPiecesArray() {
        List<Piece> pieces = UsineDePiece.getPiecesArray();
        assertEquals(2, pieces.size(), "Vérifier taille pièces par défaut");
    }

    @Test
    void testGetPiecesArrayWithColor() {
        List<Piece> pieces = UsineDePiece.getPiecesArray(Couleur.CYAN);
        assertEquals(2, pieces.size(), "Vérifier taille pièces avec couleur");
    }
}