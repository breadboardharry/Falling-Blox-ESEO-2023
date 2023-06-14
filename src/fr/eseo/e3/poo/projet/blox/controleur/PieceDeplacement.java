package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;

public class PieceDeplacement extends MouseAdapter implements KeyListener  {

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
                this.puits.gravite();
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

    public void mousePressed(MouseEvent event) {
        // Check if there is a piece defined
        if (this.puits.getPieceActuelle() == null) {
            return;
        }

        if (SwingUtilities.isMiddleMouseButton(event)) {
            this.puits.dropdown();
        }
        this.vuePuits.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            // [→] - Move to right
            case KeyEvent.VK_RIGHT:
                try {
                    this.puits.getPieceActuelle().deplacerDe(1, 0);
                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
                this.vuePuits.repaint();
                break;

            // [←] - Move down
            case KeyEvent.VK_LEFT:
                try {
                    this.puits.getPieceActuelle().deplacerDe(-1, 0);
                } catch (BloxException ex) {
                    throw new RuntimeException(ex);
                }
                this.vuePuits.repaint();
                break;

            // [↓] - Move down
            case KeyEvent.VK_DOWN:
                this.puits.gravite();
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