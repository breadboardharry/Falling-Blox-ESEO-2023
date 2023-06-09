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
