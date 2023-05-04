package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {
    ROUGE(Color.RED),
    ORANGE(Color.ORANGE),
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA);

    private final Color couleurPourAffichage;
    Couleur(Color couleur) {
        this.couleurPourAffichage = couleur;
    }
    public Color getCouleurPourAffichage() {
        return this.couleurPourAffichage;
    }
}
