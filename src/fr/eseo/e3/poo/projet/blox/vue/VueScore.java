package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Score;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Graphics2D;
import java.awt.Color;

public class VueScore {

    private Score score;

    public VueScore (Score score) {
        this.score = score;
    }

    public void afficherScore(Graphics2D g2D) {
        g2D.setColor(Color.BLACK);
        g2D.drawString("Score: " + this.score.getScore(), 10, 20);
    }
}
