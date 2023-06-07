package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

public class TasTest {

    @Test
    void testConstructeurVide() {
        Puits puit = new Puits();
        Tas tas = new Tas(puit);
        assertEquals(0, getNbElements(tas), "Constructeur tas vide");
    }

    @Test
    void testConstructeurElements() {
        Puits puit = new Puits();
        Tas tas = new Tas(puit, 12);
        assertEquals(12, getNbElements(tas), "Constructeur tas nbElements uniquement");
    }

    @Test
    void testConstructeurElementsLignes() {
        Puits puit = new Puits(10, 20);
        Tas tas1 = new Tas(puit, 39, 4);
        assertEquals(39, getNbElements(tas1), "Constructeur tas nbElements et nbLignes");

        try {
            Tas tas2 = new Tas(puit, 40, 3);
            fail("Vérifier nombre d'éléLments, une exception aurait dû être levée");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Le nombre d'éléments doit être inférieur au nombre de cases du puits", e.getMessage(), "Constructeur tas nbElements et nbLignes");
        }
    }

    @Test
    void testCollision() {
        Puits puit = new Puits();
        OPiece p = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);

        Tas tas1 = new Tas(puit, 0, 10);
        assertFalse(tas1.collision(p.getElements()), "Pas de collision");

        Tas tas2 = new Tas(puit, 99, 10);
        assertFalse(tas2.collision(p.getElements()), "Collision");
    }

    private int getNbElements(Tas tas) {
        Element[][] elements = tas.getElements();
        int nbElements = 0;

        // Get the total number of instanced elements in the two-dimensional array
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != null) nbElements++;
            }
        }
        return nbElements;
    }

    @Test
    void getPuits() {
        Puits puit = new Puits();
        Tas tas = new Tas(puit);
        assertEquals(puit, tas.getPuits(), "GetPuits");
    }

    @Test
    void getElements() {
        Puits puit = new Puits();
        Tas tas = new Tas(puit, 10);
        assertEquals(10, getNbElements(tas), "GetElements");
    }
}