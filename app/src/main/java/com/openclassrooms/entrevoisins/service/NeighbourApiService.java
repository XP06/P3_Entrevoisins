package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();



    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);


    List<Neighbour> getFavorites();


    /**
     * Deletes a favorite
     * @param favorite
     */

    void deleteFavorite(Neighbour favorite);

    void addFavorite(Neighbour favorite);
}
