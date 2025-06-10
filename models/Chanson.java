package models;

import services.ServiceCalculDuree;

public class Chanson {
    private final String interprete;
    private final String titre;
    private final int duree;

    public Chanson(String interprete, String titre, int duree) {
        this.interprete = interprete;
        this.titre = titre;
        this.duree = duree;
    }

    public String getInterprete() {
        return interprete;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        int minutes = ServiceCalculDuree.calculeMinutesEntieres(duree);
        int secondes = ServiceCalculDuree.calculeResteSecondes(duree);
        return interprete + " - " + titre + ", " + minutes + ":" + String.format("%02d", secondes);
    }
}
