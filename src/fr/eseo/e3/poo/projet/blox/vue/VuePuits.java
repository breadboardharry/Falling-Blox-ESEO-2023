package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {

    public static final int TAILLE_PAR_DEFAUT = 15;
    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    private PieceDeplacement pieceDeplacement;

    public VuePuits(Puits puits, int taille) {
        super();
        this.setPuits(puits);
        this.setTaille(taille);
        this.pieceDeplacement = new PieceDeplacement(this);

        this.addMouseListener(this.pieceDeplacement);
        this.addMouseMotionListener(this.pieceDeplacement);
        this.addMouseWheelListener(this.pieceDeplacement);
    }

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public Puits getPuits() {
        return this.puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        // Subscribe to new puits changes
        this.puits.addPropertyChangeListener(this);

        setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur() * this.taille));
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur() * this.taille));
    }

    public VuePiece getVuePiece() {
        return this.vuePiece;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        // Set background color as white
        g2D.setColor(java.awt.Color.WHITE);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        // Draw grid
        g2D.setColor(java.awt.Color.LIGHT_GRAY);
        for (int x = 0; x < getWidth(); x += this.taille) {
            for (int y = 0; y < getHeight(); y += this.taille) {
                g2D.drawRect(x, y, this.taille, this.taille);
            }
        }

        // Display the piece
        if (this.vuePiece != null) this.vuePiece.afficherPiece(g2D);

        repaint();
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        // If next piece has changed, update the view
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            Piece piece = (Piece) event.getNewValue();
            this.setVuePiece(new VuePiece(piece, this.taille));
        }
    }
}
