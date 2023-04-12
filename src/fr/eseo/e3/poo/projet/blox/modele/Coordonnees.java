package fr.eseo.e3.poo.projet.blox.modele;

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

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coordonnees)) return false;

        Coordonnees c = (Coordonnees)o;
        return c.abscisse == this.abscisse && c.ordonnee == this.ordonnee;
    }

    @Override
    public int hashCode() {
        return this.abscisse * 10000 + this.ordonnee;
    }
}