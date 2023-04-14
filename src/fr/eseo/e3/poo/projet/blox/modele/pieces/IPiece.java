package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPiece extends Piece {
    public IPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Prevents the list from being overcharged
        this.getElements().clear();

        // Add elements
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee(), couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1, couleur));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("IPiece :\n");
        // Display elements
        str.append(super.toString());
        return str.toString();
    }
}
