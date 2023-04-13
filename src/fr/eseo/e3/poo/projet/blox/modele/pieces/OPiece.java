package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public class OPiece {
    private List<Element> elements;

    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new ArrayList<>();
        this.setElements(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Prevents the list from being overcharged
        this.elements.clear();

        // Add elements
        this.elements.add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee(), couleur));
        this.elements.add(new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur));
        this.elements.add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur));
        this.elements.add(new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur));
    }

    public List<Element> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        String str = "OPiece :\n";
        // For each element, add it to the string
        for (Element element : this.elements)
            str += "\t" + element.toString() + "\n";
        return str;
    }
}

