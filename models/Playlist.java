package models;

import services.ServiceCalculDuree;

public class Playlist {
    private String proprietaire;
    private String nom;
    private Chanson[] chansons;

    public Playlist(String proprietaire, String nom) {
        this.proprietaire = proprietaire;
        this.nom = nom;
        this.chansons = new Chanson[0];
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public boolean contientChanson(Chanson chanson) {
        for (Chanson c : chansons) {
            if (c.equals(chanson)) return true;
        }
        return false;
    }

    public void ajouterChanson(Chanson chanson) {
        if (!contientChanson(chanson)) {
            Chanson[] nouveau = new Chanson[chansons.length + 1];
            for (int i = 0; i < chansons.length; i++) {
                nouveau[i] = chansons[i];
            }
            nouveau[chansons.length] = chanson;
            chansons = nouveau;
        }
    }

    public void retirerChanson(Chanson chanson) {
        int index = -1;
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i].equals(chanson)) {
                index = i;
                break;
            }
        }
        if (index == -1) return;

        Chanson[] nouveau = new Chanson[chansons.length - 1];
        for (int i = 0, j = 0; i < chansons.length; i++) {
            if (i != index) {
                nouveau[j++] = chansons[i];
            }
        }
        chansons = nouveau;
    }

    public int getDureeTotale() {
        int total = 0;
        for (Chanson c : chansons) {
            total += c.getDuree();
        }
        return total;
    }

    public int supprimerChansonsLongues(int limite) {
        int count = 0;
        for (Chanson c : chansons) {
            if (c.getDuree() > limite) count++;
        }
        Chanson[] nouveau = new Chanson[chansons.length - count];
        int j = 0;
        for (Chanson c : chansons) {
            if (c.getDuree() <= limite) {
                nouveau[j++] = c;
            }
        }
        chansons = nouveau;
        return count;
    }

    public int dureeMoyenne() {
        if (chansons.length == 0) return 0;
        return getDureeTotale() / chansons.length;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

    @Override
    public String toString() {
        int duree = getDureeTotale();
        int minutes = ServiceCalculDuree.calculeMinutesEntieres(duree);
        int secondes = ServiceCalculDuree.calculeResteSecondes(duree);
        return "Playlist \"" + nom + "\" crée par " + proprietaire + " : " + chansons.length + " titres, durée " + minutes + " minutes et " + secondes + " secondes.";
    }
}
