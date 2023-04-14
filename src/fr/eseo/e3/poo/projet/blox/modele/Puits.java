package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Objects;

public class Puits {

    public static final int LARGEUR_PAR_DEFAUT = 10; // [5 - 15]
    public static final int PROFONDEUR_PAR_DEFAUT = 20; // [15 - 25]

    private int largeur;
    private int profondeur;

    private Piece pieceActuelle;
    private Piece pieceSuivante;

    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        this.setLargeur(largeur);
        this.setProfondeur(profondeur);
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setLargeur(int largeur) {
        // Check if the given dimensions are valid
        if (largeur < 5 || largeur > 15)
            throw new IllegalArgumentException("Largeur invalide : " + largeur + " (5 - 15)");

        this.largeur = largeur;
    }

    public int getProfondeur() {
        return this.profondeur;
    }

    public void setProfondeur(int profondeur) {
        // Check if the given dimensions are valid
        if (profondeur < 15 || profondeur > 25)
            throw new IllegalArgumentException("Profondeur invalide : " + profondeur + " (15 - 25)");

        this.profondeur = profondeur;
    }

    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    public void setPieceSuivante(Piece piece) {
        // Check if there is a current piece
        if (this.getPieceSuivante() != null) {
            // If there is, set the next piece as the current one and move it
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(this.getLargeur() / 2, -4);
        }

        // Set the next piece as the given one
        this.pieceSuivante = piece;
    }

    @Override
    public String toString() {
        // Display Puits dimensions
        StringBuilder str = new StringBuilder("Puits : Dimension " + this.getLargeur() + " x " + this.getProfondeur() + "\n");

        // Display current piece
        str.append("Piece Actuelle : ");
        if (this.getPieceActuelle() == null)
            str.append("<aucune>\n");
        else
            str.append(this.getPieceActuelle().toString());

        // Display next piece
        str.append("Piece Suivante : ");
        if (this.getPieceSuivante() == null)
            str.append("<aucune>\n");
        else
            str.append(this.getPieceSuivante().toString());

        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        // Check if the object is this instance
        if (this == o) return true;
        // Check if the object is Puits
        if (o == null || getClass() != o.getClass()) return false;

        // Check if the values are the same
        Puits puits = (Puits) o;
        return largeur == puits.largeur &&
                profondeur == puits.profondeur &&
                Objects.equals(pieceActuelle, puits.pieceActuelle) &&
                Objects.equals(pieceSuivante, puits.pieceSuivante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(largeur, profondeur, pieceActuelle, pieceSuivante);
    }
}
