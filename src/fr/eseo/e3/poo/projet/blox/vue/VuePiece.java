package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Graphics2D;
import java.awt.Color;

public class VuePiece {

    public static final double MULTIPLIER_TEINTE = 0.3;

    private final int taille;
    private final Piece piece;

    public VuePiece (Piece piece, int taille) {
        super();
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur) {
        int r = couleur.getRed(), g = couleur.getGreen(), b = couleur.getBlue();

        return new java.awt.Color(
                (int) (r + (255 - r) * MULTIPLIER_TEINTE),
                (int) (g + (255 - g) * MULTIPLIER_TEINTE),
                (int) (b + (255 - b) * MULTIPLIER_TEINTE)
        );
    }
    public void afficherPiece(Graphics2D g2D) {
        // Define the color of the pieces
        Element firstElement = this.piece.getElements().get(0);
        Color color = firstElement.getCouleur().getCouleurPourAffichage();

        // For each element, draw it
        for (int i = 0; i < this.piece.getElements().size(); i++) {
            Coordonnees coordonnees = this.piece.getElements().get(i).getCoordonnees();
            int x = coordonnees.getAbscisse() * this.taille;
            int y = coordonnees.getOrdonnee() * this.taille;

            g2D.setColor(i == 0 ? teinte(color) : color);
            g2D.fill3DRect(x, y, this.taille, this.taille, true);
        }
    }
}