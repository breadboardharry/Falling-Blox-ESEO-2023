package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class PieceRotationTest {

    public PieceRotationTest() {
        testPieceRotation();
    }

    // Run test thread
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new PieceRotationTest();
            }
        });
    }

    private void testPieceRotation() {
        // Create puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Generate pieces
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        Piece piece3 = UsineDePiece.genererPiece();

        // Set the piece to display
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);
        puits.setPieceSuivante(piece3);

        // Create frame
        JFrame frame = new JFrame("Test rotation piece");
        frame.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }
}
