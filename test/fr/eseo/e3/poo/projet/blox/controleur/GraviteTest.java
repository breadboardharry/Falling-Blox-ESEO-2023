package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuitsAffichageTest;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class GraviteTest {

    public GraviteTest() {
        testGravite();
    }

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new GraviteTest();
            }
        });
    }

    void testGravite() {
        // Create puits
        Puits puits = new Puits(12, 20, 35, 10);
        VuePuits vuePuits = new VuePuits(puits, 22);
        Gravite gravite = new Gravite(vuePuits);

        vuePuits.setGravite(gravite);

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
