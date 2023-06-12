package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Objects;

public class Puits {

    public static final int LARGEUR_PAR_DEFAUT = 10; // [5 - 15]
    public static final int PROFONDEUR_PAR_DEFAUT = 20; // [15 - 25]
    public static final String MODIFICATION_PIECE_ACTUELLE = "PieceActuelleChanged";
    public static final String MODIFICATION_PIECE_SUIVANTE = "PieceSuivanteChanged";

    private int largeur;
    private int profondeur;

    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private Tas tas;
    private Score score;

    private PropertyChangeSupport pcs;

    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        this(largeur, profondeur, 0, 0);
    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        this.setLargeur(largeur);
        this.setProfondeur(profondeur);
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this, nbElements, nbLignes);
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
        piece.setPuits(this);
        // Check if there is a current piece
        if (this.pieceSuivante != null) {
            // If there is, set the next piece as the current one and move it
            Piece prevPiece = this.pieceActuelle;
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(this.getLargeur() / 2, -4);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, prevPiece, this.pieceActuelle);
        }

        // Set the next piece as the given one and inform the listeners
        Piece prevPiece = this.pieceSuivante;
        this.pieceSuivante = piece;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, prevPiece, this.pieceSuivante);
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    public Tas getTas() {
        return this.tas;
    }

    public boolean sorti(List<Element> elements) {
        // Check if the piece is out of the pit
        for (Element element : elements) {
            if (element.getCoordonnees().getAbscisse() < 0 || element.getCoordonnees().getAbscisse() >= this.getLargeur())
                return true;
        }

        return false;
    }

    public boolean sortiFond(List<Element> elements) {
        // Check if the piece is out of the pit
        for (Element element : elements) {
            if (element.getCoordonnees().getOrdonnee() >= this.getProfondeur()) return true;
        }

        return false;
    }

    private void gererCollision() {
        this.tas.ajouterElements(this.pieceActuelle);
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        this.setPieceSuivante(UsineDePiece.genererPiece());
    }

    public void gravite() {
        try {
            this.pieceActuelle.deplacerDe(0, 1);
        }
        catch (BloxException e) {
            // Check if the piece is out of the pit
            if (e.getType() == BloxException.BLOX_COLLISION) this.gererCollision();
            else throw new RuntimeException(e);
        }
    }

    /**
     * Make the current piece fall until it collides with another piece
     */
    public void dropdown() {
        try {
            while (true) {
                this.pieceActuelle.deplacerDe(0, 1);
            }
        }
        catch (BloxException e) {
            // Check if the piece is out of the pit
            if (e.getType() == BloxException.BLOX_COLLISION) this.gererCollision();
            else throw new RuntimeException(e);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
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
