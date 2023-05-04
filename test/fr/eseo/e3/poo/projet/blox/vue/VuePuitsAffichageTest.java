package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuitsTaille();
        testConstructeurPuits();
        testAffichagePiece();
    }

    // Run test thread
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new VuePuitsAffichageTest();
            }
        });
    }

    private void testConstructeurPuits() {
        // Instantiate puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Create frame
        JFrame frame = new JFrame("Puits");
        frame.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }

    private void testConstructeurPuitsTaille() {
        // Instantiate puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 25);

        // Create frame
        JFrame frame = new JFrame("Puits et taille");
        frame.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }

    private void testAffichagePiece() {
        // Instantiate puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Generate random piece
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();

        // Set the piece to display
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);

        // Create frame
        JFrame frame = new JFrame("Puits piece");
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
