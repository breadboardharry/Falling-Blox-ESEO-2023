package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Score;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    private Puits puits;
    private VuePiece vuePiece;
    private Score score;

    public static final int TAILLE_PREVIEW_PIECE_SUIVANTE = 10;
    public static final int PREFERRED_SIZE = 70;
    public static final int TOTAL_SIZE = TAILLE_PREVIEW_PIECE_SUIVANTE + PREFERRED_SIZE + 4;

    public PanneauInformation(Puits puits, Score score) {
        super();
        this.puits = puits;
        this.score = score;
        this.puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
    }

    public PanneauInformation(Puits puits) {
        this(puits, null);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.puits.addPropertyChangeListener(listener);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        // Display next piece
        if (this.vuePiece != null) {
            this.vuePiece.afficherPiece(g2D);
        }

        // Display score
        if (this.score != null) {
            VueScore vueScore = new VueScore(this.score);
            g2D.translate(0, 50);
            vueScore.afficherScore(g2D);
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
