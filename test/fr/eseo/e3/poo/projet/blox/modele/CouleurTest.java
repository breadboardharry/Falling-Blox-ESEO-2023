package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CouleurTest {

    @Test
    void testGetCouleurPourAffichage() {
        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }

    @Test
    void testValues() {
        Couleur[] couleurs = Couleur.values();
        assertEquals(7, couleurs.length);
        assertSame(Couleur.ROUGE, couleurs[0]);
        assertSame(Couleur.ORANGE, couleurs[1]);
        assertSame(Couleur.BLEU, couleurs[2]);
        assertSame(Couleur.VERT, couleurs[3]);
        assertSame(Couleur.JAUNE, couleurs[4]);
        assertSame(Couleur.CYAN, couleurs[5]);
        assertSame(Couleur.VIOLET, couleurs[6]);
    }

    @Test
    void testValueOf() {
        assertEquals(Couleur.ROUGE, Couleur.valueOf("ROUGE"));
        assertEquals(Couleur.ORANGE, Couleur.valueOf("ORANGE"));
        assertEquals(Couleur.BLEU, Couleur.valueOf("BLEU"));
        assertEquals(Couleur.VERT, Couleur.valueOf("VERT"));
        assertEquals(Couleur.JAUNE, Couleur.valueOf("JAUNE"));
        assertEquals(Couleur.CYAN, Couleur.valueOf("CYAN"));
        assertEquals(Couleur.VIOLET, Couleur.valueOf("VIOLET"));
    }
}