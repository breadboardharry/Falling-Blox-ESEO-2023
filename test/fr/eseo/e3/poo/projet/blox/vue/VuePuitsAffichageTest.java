package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import javafx.css.Size;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
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
}
