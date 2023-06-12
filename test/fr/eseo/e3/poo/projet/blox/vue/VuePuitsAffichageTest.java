package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuitsTaille();
        testConstructeurPuits();
        testAffichagePiece();
        testExceptions();
        testAffichageTas();
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

    private void testExceptions() {
        // Create puits
        Puits puits = new Puits(12, 24);
        VuePuits vuePuits = new VuePuits(puits, 25);

        // Generate pieces
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();

        // Set the piece to display
        puits.setPieceSuivante(piece2);
        puits.setPieceSuivante(piece1);

        Tas tas = new Tas(puits);
        puits.setTas(tas);

        // Create frame
        JFrame frame = new JFrame("Puits exceptions");
        frame.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }

    private void testConstructeurPuits() {
        // Create puits
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
        // Create puits
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
        // Create puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Generate pieces
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

    private void testAffichageTas() {
        // Create puits
        Puits puits = new Puits(12, 20, 35, 10);
        VuePuits vuePuits = new VuePuits(puits, 22);

        // Generate pieces
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();

        // Set the piece to display
        puits.setPieceSuivante(piece2);
        puits.setPieceSuivante(piece1);

        // Create frame
        JFrame frame = new JFrame("Affichage tas");
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
