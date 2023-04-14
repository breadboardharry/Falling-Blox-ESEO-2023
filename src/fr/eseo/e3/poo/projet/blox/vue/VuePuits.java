package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.JPanel;

public class VuePuits extends JPanel {

    public static final int TAILLE_PAR_DEFAUT = 20;
    private Puits puits;
    private int taille;

    public VuePuits(Puits puits, int taille) {
        super();
        this.setPuits(puits);
        this.setTaille(taille);
    }

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public Puits getPuits() {
        return this.puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
}