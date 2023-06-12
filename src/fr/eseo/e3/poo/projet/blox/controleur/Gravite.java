package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {
    private Timer timer;
    private final VuePuits vuePuits;
    private final Puits puits;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();

        this.timer = new Timer(1000, this);
        this.timer.start();
    }

    public int getPeriodicite() {
        return this.timer.getDelay();
    }

    public void setPeriodicite(int periodicite) {
        this.timer.setDelay(periodicite);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Each period, apply gravity to the puits
        this.puits.gravite();
        this.vuePuits.repaint();
    }
}
