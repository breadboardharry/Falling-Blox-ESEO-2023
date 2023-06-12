package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    private Puits puits;
    private VuePiece vuePiece;

    public PanneauInformation(Puits puits) {
        super();
        this.puits = puits;
        this.puits.setLargeur(70);
        this.puits.setProfondeur(70);
        this.puits.addPropertyChangeListener(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.puits.addPropertyChangeListener(listener);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        if (this.vuePiece != null) {
            this.vuePiece.afficherPiece(g2D);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            Piece piece = (Piece) event.getNewValue();
            this.vuePiece = new VuePiece(piece, 10);
        }
    }
}
