package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece {
    private List<Element> elements;
    private Puits puits;

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

    public Puits getPuits() {
        return this.puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void deplacerDe(int deltaX, int deltaY) {
        // Check inputs
        if ((deltaX > 1 || deltaX < -1) || (deltaY > 1 || deltaY < 0))
            throw new IllegalArgumentException("Delta X must be between -1 and 1 and Delta Y must be between 0 and 1");

        // Move each element
        for (Element element : this.elements)
            element.deplacerDe(deltaX, deltaY);
    }

    public void tourner(boolean sensHoraire) {
        // Get the pivot
        Element pivot = this.elements.get(0);
        int pivotX = pivot.getCoordonnees().getAbscisse();
        int pivotY = pivot.getCoordonnees().getOrdonnee();

        // Calculate sin and cos based on rotation direction
        int sign = sensHoraire ? 1 : -1;
        double cos = Math.cos(sign * Math.PI / 2);
        double sin = Math.sin(sign * Math.PI / 2);


        // Iterate over all elements and rotate them around the pivot
        for (Element element : elements) {
            // Translate element coordinates to origin
            int x = element.getCoordonnees().getAbscisse() - pivotX;
            int y = element.getCoordonnees().getOrdonnee() - pivotY;

            // Apply rotation transformation
            int rotatedX = (int) Math.round(x * cos - y * sin);
            int rotatedY = (int) Math.round(x * sin + y * cos);

            // Translate back to original coordinates and update element
            element.setCoordonnees(new Coordonnees(rotatedX + pivotX, rotatedY + pivotY));
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        // For each element, add it to the string
        for (Element element : this.elements)
            str.append("\t").append(element.toString()).append("\n");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        // Check if the object is this instance
        if (this == o) return true;
        // Check if the object is a Piece
        if (o == null || getClass() != o.getClass()) return false;

        // Check if the values are the same
        Piece piece = (Piece) o;

        for (Element element : this.elements)
            if (!piece.elements.contains(element))
                return false;

        return piece.getPuits() == this.getPuits();
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, puits);
    }
}
