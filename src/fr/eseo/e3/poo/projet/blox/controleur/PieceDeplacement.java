package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

public class PieceDeplacement extends MouseAdapter {

    private VuePuits vuePuits;
    private Puits puits;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    private int lastColunm;
    private boolean firstTime = true;


    public void mouseEntered(MouseEvent event) {
        this.firstTime = true;
    }

    public void mouseWheelMoved(MouseWheelEvent event) {
        if (this.puits.getPieceActuelle() != null) {
            if (event.getWheelRotation() > 0) {
                try {
                    this.puits.getPieceActuelle().deplacerDe(0, 1);
                } catch (BloxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        this.vuePuits.repaint();
    }

    public void mouseMoved(MouseEvent event) {
        if (this.puits.getPieceActuelle() != null) {

            int currentColunm = event.getX() / this.vuePuits.getTaille();

            if (firstTime) {
                firstTime = false;
                this.lastColunm = currentColunm;
            }
            else if (currentColunm != this.lastColunm) {
                int dx = currentColunm - this.lastColunm;
                dx = dx > 0 ? 1 : -1;
                try {
                    this.puits.getPieceActuelle().deplacerDe(dx, 0);
                } catch (BloxException e) {
                    throw new RuntimeException(e);
                }
                this.lastColunm = currentColunm;
            }
        }
        this.vuePuits.repaint();
    }
}