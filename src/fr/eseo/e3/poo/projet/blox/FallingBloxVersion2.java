package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FallingBloxVersion2 {
    public static void main(String[] args) {
        System.out.println("Falling Blox Version 2");
        if (args.length == 0) {
            FallingBloxVersion2.run(0, 0);
        }
        else if (args.length == 1) {
            FallingBloxVersion2.run(Integer.parseInt(args[0]), 0);
        }
        else {
            FallingBloxVersion2.run(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
    }

    protected static void run(int nbElements, int nbLignes) {
        // Create puits
        Puits puits = new Puits(8, 20);
        VuePuits vuePuits = new VuePuits(puits, 20);
        Gravite gravite = new Gravite(vuePuits);

        PanneauInformation panneauInformation = new PanneauInformation(puits);

        // Generate pieces
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();

        // Set the piece to display
        puits.setPieceSuivante(piece2);
        puits.setPieceSuivante(piece1);

        vuePuits.setGravite(gravite);

        /* --------- FRAME --------- */

        // Create frame
        JFrame frame = new JFrame("Falling Blox");
        frame.setSize(
                puits.getLargeur() * vuePuits.getTaille() + PanneauInformation.TOTAL_SIZE,
                puits.getProfondeur() * vuePuits.getTaille() + 37
        );
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
        frame.add(panneauInformation, BorderLayout.EAST);
    }
}
