package services;

public class ServiceCalculDuree {
    public static int calculeDureeSecondes(int minutes, int secondes) {
        return minutes * 60 + secondes;
    }

    public static int calculeMinutesEntieres(int dureeSecondes) {
        return dureeSecondes / 60;
    }

    public static int calculeResteSecondes(int dureeSecondes) {
        return dureeSecondes % 60;
    }
}