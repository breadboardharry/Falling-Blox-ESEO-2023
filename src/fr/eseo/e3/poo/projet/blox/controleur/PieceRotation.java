package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceRotation extends MouseAdapter {

    private VuePuits vuePuits;
    private Puits puits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // Check if there is a piece to rotate
        if (this.puits.getPieceActuelle() == null) {
            return;
        }

        if (SwingUtilities.isLeftMouseButton(event)) {
            try {
                this.puits.getPieceActuelle().tourner(false);
            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
        }
        else if (SwingUtilities.isRightMouseButton(event)) {
            try {
                this.puits.getPieceActuelle().tourner(true);
            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
