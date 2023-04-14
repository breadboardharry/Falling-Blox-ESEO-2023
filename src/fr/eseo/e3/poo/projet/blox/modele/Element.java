package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

    private Couleur couleur;
    private Coordonnees coordonnees;

    public Element(Coordonnees coordonnees) {
        this(coordonnees, Couleur.values()[0]);
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee));
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    public Coordonnees getCoordonnees() {
        return this.coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return this.coordonnees.toString() + " - " + this.couleur.toString();
    }

    @Override
    public boolean equals(Object o) {
        // Check if the object is this instance
        if (this == o) return true;
        // Check if the object is an Element
        if (o == null || getClass() != o.getClass()) return false;

        // Check if the values are the same
        Element element = (Element) o;
        return this.couleur == element.couleur && Objects.equals(this.coordonnees, element.coordonnees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.coordonnees, this.couleur);
    }
}