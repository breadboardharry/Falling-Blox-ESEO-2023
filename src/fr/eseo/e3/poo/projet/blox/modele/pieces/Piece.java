package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private List<Element> elements;

    public Piece(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new ArrayList<>();
        this.setElements(coordonnees, couleur);
    }

    public List<Element> getElements() {
        return this.elements;
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    public void setPosition(int abscisse, int ordonnee) {
        this.setElements(new Coordonnees(abscisse, ordonnee), this.getElements().get(0).getCouleur());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        // For each element, add it to the string
        for (Element element : this.elements)
            str.append("\t").append(element.toString()).append("\n");
        return str.toString();
    }
}
