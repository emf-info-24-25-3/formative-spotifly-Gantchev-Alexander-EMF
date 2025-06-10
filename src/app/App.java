package app;

import models.*;
import services.ServiceCalculDuree;

public class App {
    public static void main(String[] args) {
        Chanson c1 = new Chanson("Lady Gaga", "Just Dance", ServiceCalculDuree.calculeDureeSecondes(4,2));
        Chanson c2 = new Chanson("Lady Gaga", "Poker Face", ServiceCalculDuree.calculeDureeSecondes(3,59));
        Chanson c3 = new Chanson("Lady Gaga", "Paparazzi", ServiceCalculDuree.calculeDureeSecondes(3,28));
        Chanson c4 = new Chanson("PSY", "Gangnam Style", ServiceCalculDuree.calculeDureeSecondes(3,39));
        Chanson c5 = new Chanson("Nemo", "The Code", ServiceCalculDuree.calculeDureeSecondes(3,30));

        Chanson[] chansonsGaga = {c1, c2, c3};
        Chanson[] chansonsPsy = {c4};
        Chanson[] chansonsNemo = {c5};

        Album a1 = new Album("The Fame", "Lady Gaga", chansonsGaga);
        Album a2 = new Album("Psy 6", "PSY", chansonsPsy);
        Album a3 = new Album("The Code", "Nemo", chansonsNemo);

        Album[] bibliotheque = {a1, a2, a3};

        Playlist[] playlists = new Playlist[5];
        playlists[0] = new Playlist("fan2Squ33zie", "Playlist pour les vacances");
        playlists[4] = new Playlist("Alexander Gantchev", "Concentration - Revisions");

        playlists[0].ajouterChanson(c1);
        playlists[0].ajouterChanson(c2);
        playlists[0].ajouterChanson(c3);
        playlists[0].ajouterChanson(c5);

        playlists[4].ajouterChanson(c4);

        System.out.println("Bibliothèque:\n****************************");
        for (Album album : bibliotheque) {
            System.out.println(album);
            for (Chanson chanson : album.getChansons()) {
                System.out.println(chanson);
            }
            System.out.println("****************************");
        }

        System.out.println("Playlists:\n****************************");
        for (Playlist pl : playlists) {
            if (pl != null) {
                System.out.println(pl);
                for (Chanson chanson : pl.getChansons()) {
                    System.out.println(chanson);
                }
                System.out.println("****************************");
            }
        }
    }
}
