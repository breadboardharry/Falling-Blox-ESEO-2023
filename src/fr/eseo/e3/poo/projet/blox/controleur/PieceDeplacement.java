package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PieceDeplacement implements MouseMotionListener {

    private VuePuits vuePuits;
    private Puits puits;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();

    }

    private int lastColunm;
    private boolean firstTime = true;


    public void mouseMoved(MouseEvent event) {
        if (this.puits.getPieceActuelle() != null) {

            int currentColunm = event.getX() / this.vuePuits.getTaille();

            if (firstTime) {
                firstTime = false;
                this.lastColunm = currentColunm;
            }
            else if (currentColunm != this.lastColunm) {
                this.puits.getPieceActuelle().deplacerDe(currentColunm - this.lastColunm, 0);
                this.lastColunm = currentColunm;
            }
        }
    }

    public void mouseDragged(MouseEvent event) {

    }
}