package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPiece extends Piece {

    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Prevents the list from being overcharged
        this.getElements().clear();

        // Add elements
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee(), couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur));
        this.getElements().add(new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1, couleur));
    }

    @Override
    public void tourner(boolean sensHoraire) {
        // Nothing to do
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("OPiece :\n");
        // Display elements
        str.append(super.toString());
        return str.toString();
    }
}

