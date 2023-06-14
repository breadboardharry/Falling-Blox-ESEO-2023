package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsineDePiece {

    public static final int ALEATOIRE_COMPLET = 1;
    public static final int ALEATOIRE_PIECE = 2;
    public static final int CYCLIC = 3;
    private static int mode = ALEATOIRE_PIECE;
    private static int cycleIndex;

    private UsineDePiece() {
    }

    public static void setMode(int mode) {
        UsineDePiece.mode = mode;
        // Reset the index if the mode is cyclic
        if (mode == CYCLIC) UsineDePiece.cycleIndex = 0;
    }

    public static int getMode() {
        return UsineDePiece.mode;
    }

    public static Piece genererPiece() {
        Piece piece;

        switch (UsineDePiece.mode) {
            case ALEATOIRE_COMPLET:
                // Select a random piece with a random color
                piece = UsineDePiece.getRandomPiece(UsineDePiece.getPiecesArray(UsineDePiece.getRandomCouleur()));
                break;

            case ALEATOIRE_PIECE:
                // Select a random piece with its original color
                piece = UsineDePiece.getRandomPiece(UsineDePiece.getPiecesArray());
                break;

            case CYCLIC:
                // Select the piece at the current index and increment the index
                piece = UsineDePiece.getPiecesArray().get(UsineDePiece.cycleIndex);
                UsineDePiece.cycleIndex = (UsineDePiece.cycleIndex + 1) % UsineDePiece.getPiecesArray().size();
                break;

            // Invalid mode
            default:
                throw new IllegalArgumentException("Mode invalide : " + mode);
        }

        // Set the position of the piece and return it
        piece.setPosition(2, 3);
        return piece;
    }

    private static Couleur getRandomCouleur() {
        // List all colors
        Couleur[] colors = Couleur.values();
        // Create a random object
        Random random = new Random();

        // Return a random color
        return colors[random.nextInt(colors.length)];
    }

    private static Piece getRandomPiece(List<Piece> pieces) {
        // Create a random object
        Random random = new Random();
        // Return a random piece from the array
        return pieces.get(random.nextInt(pieces.size()));
    }

    public static List<Piece> getPiecesArray() {
        List<Piece> list = new ArrayList<Piece>();
        list.add(new OPiece(new Coordonnees(0, 0), Couleur.ROUGE));
        list.add(new IPiece(new Coordonnees(0, 0), Couleur.ORANGE));
        return list;
    }

    public static List<Piece> getPiecesArray(Couleur couleur) {
        List<Piece> list = new ArrayList<Piece>();
        list.add(new OPiece(new Coordonnees(0, 0), couleur));
        list.add(new IPiece(new Coordonnees(0, 0), couleur));
        return list;
    }
}
