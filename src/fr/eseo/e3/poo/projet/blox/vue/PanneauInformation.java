package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    private Puits puits;
    private VuePiece vuePiece;

    public static final int TAILLE_PREVIEW_PIECE_SUIVANTE = 10;
    public static final int PREFERRED_SIZE = 70;

    public PanneauInformation(Puits puits) {
        super();
        this.puits = puits;
        this.puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
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

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            Piece piece = (Piece) event.getNewValue();
            this.vuePiece = new VuePiece(piece, TAILLE_PREVIEW_PIECE_SUIVANTE);
        }

        this.repaint();
    }
}
