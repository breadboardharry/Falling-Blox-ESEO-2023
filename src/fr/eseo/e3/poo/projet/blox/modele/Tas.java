package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.List;
import java.util.Random;

public class Tas {

    private Puits puits;
    private Element[][] elements;

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
        this.construireTas(nbElements, nbLignes, new Random());
    }

    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, (nbElements / puits.getLargeur()) + 1);
    }

    public Tas(Puits puits) {
        this(puits, 0, 0);
    }

    public boolean collision(List<Element> elements) {
        for (Element[] elems : this.elements) {
            for (Element elem : elems) {
                for (Element element : elements) {
                    if (elem != null && elem.collision(element)) return true;
                }
            }
        }
        return false;
    }

    public void ajouterElements(Piece piece) {
        for (Element element : piece.getElements()) {
            this.elements[element.getCoordonnees().getOrdonnee()][element.getCoordonnees().getAbscisse()] = element;
        }
        this.harmoniser();
    }

    /**
     * Copy a line to another and move all the elements down
     * @param src the index of the line to copy
     * @param dest the index of the line to copy to
     */
    private void copierLigne(int src, int dest) {
        int delta = dest - src;
        for (int i = 0; i < this.puits.getLargeur(); i++) {
            this.elements[dest][i] = this.elements[src][i];
            if (this.elements[dest][i] != null) {
                this.elements[dest][i].deplacerDe(0, delta);
            }
        }
    }

    /**
     * Fill a line with null elements
     * @param ligne the index of the line to empty
     */
    private void viderLigne(int ligne) {
        for (int i = 0; i < this.puits.getLargeur(); i++) {
            this.elements[ligne][i] = null;
        }
    }

    /**
     * Check if lines are full and delete them
     */
    private void harmoniser() {
        // For each line starting from the bottom
        for (int ligne = this.puits.getProfondeur() - 1; ligne >= 0; ligne--) {
            // If the line is full
            if (this.ligneRemplie(ligne)) {
                // Makes fall the lines above
                for (int i = ligne; i > 0; i--) {
                    this.viderLigne(i);
                    this.copierLigne(i - 1, i);
                    this.viderLigne(i-1);
                }
                // Add 10 points to the score
                this.puits.getScore().ajouter(10);
                // Recheck the line
                ligne += 1;
            }
        }
    }

    /**
     * Check if a line is full of elements
     * @param ligne the index of the line to check
     * @return true if the line is full, false otherwise
     */
    private boolean ligneRemplie(int ligne) {
        for (int i = 0; i < this.puits.getLargeur(); i++) {
            if (this.elements[ligne][i] == null) return false;
        }
        return true;
    }

    public Puits getPuits() {
        return puits;
    }

    public Element[][] getElements() {
        return this.elements;
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {

        if (nbElements != 0 && nbElements >= (this.puits.getLargeur() * nbLignes)) {
            throw new IllegalArgumentException("Le nombre d'éléments doit être inférieur au nombre de cases du puits");
        }

        int placed = 0;

        while (placed < nbElements) {
            int ordon = this.puits.getProfondeur() - (rand.nextInt(nbLignes) + 1);
            int absci = rand.nextInt(this.puits.getLargeur());

            if (this.elements[ordon][absci] == null) {
                int indiceCouleur = rand.nextInt(Couleur.values().length);
                this.elements[ordon][absci] = new Element(new Coordonnees(absci, ordon), Couleur.values()[indiceCouleur]);
                placed++;
            }
        }
    }
}
