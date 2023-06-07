package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {

    public final static int BLOX_COLLISION = 0;
    public final static int BLOX_SORTIE_PUITS = 1;

    private int type;

    public BloxException(String message, int type) {
        super(message);
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
