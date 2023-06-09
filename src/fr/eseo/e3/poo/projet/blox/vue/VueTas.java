package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueTas {
    public static final double MULTIPLIER_NUANCE = 0.3;

    private final VuePuits vuePuits;
    private final Tas tas;

    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.tas = vuePuits.getPuits().getTas();
    }

    public Color nuance(Color couleur) {
        int r = couleur.getRed(), g = couleur.getGreen(), b = couleur.getBlue();

        return new java.awt.Color(
                (int) (r * (1 - MULTIPLIER_NUANCE)),
                (int) (g * (1 - MULTIPLIER_NUANCE)),
                (int) (b * (1 - MULTIPLIER_NUANCE))
        );
    }

    public void afficher(Graphics2D g2D) {
        int taille = this.vuePuits.getTaille();

        // Display each element of the tas if it is not null
        for (int i = 0; i < this.tas.getElements().length; i++) {
            for (int j = 0; j < this.tas.getElements()[i].length; j++) {
                Element elem = this.tas.getElements()[i][j];

                if (elem == null) continue;

                Coordonnees coordonnees = elem.getCoordonnees();
                int x = coordonnees.getAbscisse() * taille, y = coordonnees.getOrdonnee() * taille;
                Color color = elem.getCouleur().getCouleurPourAffichage();

                g2D.setColor(nuance(color));
                g2D.fill3DRect(x, y, taille, taille, true);
            }
        }
    }

    public VuePuits getVuePuits() {
        return this.vuePuits;
    }
}