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

    /**
     * Add a Neighbour to FavoriteNeighbour
     * @param neighbour
     */
    void addNeighbourFavorite(Neighbour neighbour);

    /**
     * boolean to check if Neighbour is favorite or No
     * @param neighbour
     * @return
     */
    Boolean isFavorite(Neighbour neighbour);

    /**
     * List of favorite Neighbours
     * @return
     */
    List<Neighbour> getFavoriteNeighbour();

    /**
     * Delete from favorite Neighbour
     */
    void removeFavoriteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);
}
