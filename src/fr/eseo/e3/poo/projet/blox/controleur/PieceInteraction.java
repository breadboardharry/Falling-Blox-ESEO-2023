package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PieceInteraction implements KeyListener {

    private VuePuits vuePuits;
    private Puits puits;

    public PieceInteraction(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            // [R] - Switch piece
            case KeyEvent.VK_R:
                this.puits.echangerPiece();
                this.vuePuits.repaint();
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
