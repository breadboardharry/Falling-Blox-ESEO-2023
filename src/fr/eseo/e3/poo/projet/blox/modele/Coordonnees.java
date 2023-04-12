package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return this.abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return this.ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void setCoordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString() {
        return "(" + this.abscisse + ", " + this.ordonnee + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnees c = (Coordonnees) o;
        return this.abscisse == c.abscisse && this.ordonnee == c.ordonnee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.abscisse, this.ordonnee);
    }
}