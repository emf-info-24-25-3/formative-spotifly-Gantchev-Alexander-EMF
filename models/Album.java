package models;

import services.ServiceCalculDuree;
import java.util.Random;

public class Album {
    private final String titre;
    private final String interprete;
    private final Chanson[] chansons;

    public Album(String titre, String interprete, Chanson[] chansons) {
        this.titre = titre;
        this.interprete = interprete;
        this.chansons = chansons;
    }

    public String getTitre() {
        return titre;
    }

    public String getInterprete() {
        return interprete;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

    public int getDureeTotale() {
        int total = 0;
        for (Chanson c : chansons) {
            total += c.getDuree();
        }
        return total;
    }

    public Chanson rechercheParTitre(String titreRecherche) {
        for (Chanson c : chansons) {
            if (c.getTitre().equalsIgnoreCase(titreRecherche)) {
                return c;
            }
        }
        return null;
    }

    public int dureeMaxChanson() {
        int max = 0;
        for (Chanson c : chansons) {
            if (c.getDuree() > max) {
                max = c.getDuree();
            }
        }
        return max;
    }

    public Chanson chansonAleatoire() {
        Random rand = new Random();
        return chansons[rand.nextInt(chansons.length)];
    }

    @Override
    public String toString() {
        int duree = getDureeTotale();
        int minutes = ServiceCalculDuree.calculeMinutesEntieres(duree);
        int secondes = ServiceCalculDuree.calculeResteSecondes(duree);
        return titre + " par " + interprete + " : " + chansons.length + " titres, durée " + minutes + " minutes et " + secondes + " secondes";
    }
}
