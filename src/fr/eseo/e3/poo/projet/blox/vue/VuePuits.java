package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.JPanel;
import java.awt.*;

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
        setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur() * this.taille));
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur() * this.taille));
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

        g2D.dispose();
    }
}
