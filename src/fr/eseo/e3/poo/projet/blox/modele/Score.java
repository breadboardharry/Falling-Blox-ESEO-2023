package fr.eseo.e3.poo.projet.blox.modele;

import com.sun.tools.jconsole.JConsoleContext;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;

public class Score {

    private int score = 0;
    private Gravite gravite;
    private float speed;

    public Score(Gravite gravite) {
        this.gravite = gravite;
        this.updateSpeed();
    }

    public void ajouter(int points) {
        if (points < 0) return;
        this.score += points;
        this.updateSpeed();
        System.out.println("+" + points + "points");
    }

    public int getScore() {
        return this.score;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void reset() {
        this.score = 0;
        this.updateSpeed();
    }

    private void updateSpeed() {
        this.speed = 1 + ((float)this.score / 1000);
        this.gravite.setPeriodicite(Math.round(1000/speed));
        System.out.printf("div: %.2f\n", (float)this.score / 1000);
        System.out.println("Points: " + this.score);
        System.out.printf("Speed: %.2f\n", this.speed);
        System.out.println("Millis: " + Math.round(1000/speed));
    }
}
