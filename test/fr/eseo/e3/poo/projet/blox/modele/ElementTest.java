package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

    @Test
    void testContructeur1() {
        Element e1 = new Element(new Coordonnees(1, 2));
        Element e2 = new Element(new Coordonnees(1, 2));
        assertEquals(Couleur.values()[0], e1.getCouleur(), "Vérifier couleur par défaut");
        assertEquals(e1, e2, "Deux mêmes objets via constructeur 1");
    }

    @Test
    void testContructeur2() {
        Element e1 = new Element(1, 2);
        Element e2 = new Element(1, 2);
        assertEquals(Couleur.values()[0], e1.getCouleur(), "Vérifier couleur par défaut");
        assertEquals(e1, e2, "Deux mêmes objets via constructeur 2");
    }

    @Test
    void testContructeur3() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals(e1, e2, "Deux mêmes objets via constructeur 3");
    }

    @Test
    void testContructeur4() {
        Element e1 = new Element(1, 2, Couleur.BLEU);
        Element e2 = new Element(1, 2, Couleur.BLEU);
        assertEquals(e1, e2, "Deux mêmes objets via constructeur 4");
    }

    @Test
    void testGetCoordonnees() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals(new Coordonnees(1, 2), e.getCoordonnees(), "Get coordonnées");
    }

    @Test
    void testSetCoordonnees() {
        Element e = new Element(new Coordonnees(0, 0), Couleur.BLEU);
        e.setCoordonnees(new Coordonnees(1, 2));
        assertEquals(new Coordonnees(1, 2), e.getCoordonnees(), "Set coordonnées");
    }

    @Test
    void testGetCouleur() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals(Couleur.BLEU, e.getCouleur(), "Get couleur");
    }

    @Test
    void testSetCouleur() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.JAUNE);
        e.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, e.getCouleur(), "Set couleur");
    }

    @Test
    void testDeplacerDe() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.JAUNE);
        e.deplacerDe(1, -2);
        assertEquals(new Coordonnees(2, 0), e.getCoordonnees(), "Deplacer de");
    }

    @Test
    void testToString() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals("(1, 2) - BLEU", e.toString(), "ToString");
    }

    @Test
    void testCollision() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
        Element e3 = new Element(new Coordonnees(2, 1), Couleur.ORANGE);

        assertEquals(true, e1.collision(e2), "Collision de deux elements");
        assertEquals(false, e1.collision(e3), "Non collision de deux elements");
    }

    @Test
    void testEquals() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        Element e3 = new Element(new Coordonnees(2, 1), Couleur.BLEU);
        assertEquals(true, e1.equals(e2), "Equals deux mêmes objets");
        assertEquals(false, e1.equals(e3), "Equals deux objets différents");
    }
}