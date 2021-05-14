package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private final List<Neighbour> favorites = DummyNeighbourGenerator.generateFavorites();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    public List<Neighbour> getFavorites() {
        return favorites;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    public void deleteFavorite(Neighbour favorite) {
        favorites.remove(favorite);
    }

    public void addFavorite(Neighbour favorite) {
        favorites.add(favorite);
    }

}



