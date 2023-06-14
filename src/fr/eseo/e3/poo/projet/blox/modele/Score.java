package fr.eseo.e3.poo.projet.blox.modele;

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
    }
}
