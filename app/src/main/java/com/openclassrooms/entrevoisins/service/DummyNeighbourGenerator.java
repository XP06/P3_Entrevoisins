package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

    public static List<Neighbour> generateFavNeighbours() {
        return new ArrayList<>(FAV_NEIGHBOURS);
    }

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint Pierre du mont à 5 km","+33 6 86 57 90 14","www.facebook.fr/caroline","Bonjour ! Je souhaiterais faire de la marche nordique, Pas initiée ,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot…"),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","Mousseline en brie à 4 km","+33 6 00 00 00 00","www.facebook.fr/jack","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f","Moulin à huile à 2 km","+33 6 00 00 00 03","www.facebook.fr/chloé","Bonjour ! Je souhaiterais faire de la marche nordique, Pas initiée ,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot…"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a","Moulin à Poivre à 1 km","+33 6 00 00 00 04","www.facebook.fr/vincent","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b","Coriandre à 2 km","+33 6 00 00 00 05","www.facebook.fr/élodie","Bonjour ! Je souhaiterais faire de la marche nordique, Pas initiée ,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot…"),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c","Salade à 6 km","+33 6  00 00 00 06","www.facebook.fr/sylvain","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d","Yuzu à 1 km","+33 6  00 00 00 07","www.facebook.fr/laetitia","Bonjour ! Je souhaiterais faire de la marche nordique, Pas initiée ,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot…"),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b","Rue du Marlin à 500 m","+33 6  00 00 00 08","www.facebook.fr/dan","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Route de la brioche 2 km","+33 6  00 00 00 09","www.facebook.fr/joseph","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d","Impasse de l'impasse à 800 m","+33 6  00 00 00 10","www.facebook.fr/emma","Bonjour ! Je souhaiterais faire de la marche nordique, Pas initiée ,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot…"),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d","Rue de la Marche à 300 m","+33 6 00 00 00 11","www.facebook.fr/patrick","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…"),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d","Chemin de la fin à 5 km","+33  600 00 00 12","www.facebook.fr/ludovic","Bonjour ! Je souhaiterais faire des balades entre Bikers, Passioné,je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les grands espaces et les amis…")

            );
    // Création de la liste des favoris //

    public static List<Neighbour> FAV_NEIGHBOURS = Arrays.asList(


    );


}
