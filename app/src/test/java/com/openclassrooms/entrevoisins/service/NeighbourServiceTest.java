package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     * Check if NeighbourFavorite is not empty after adding a neighbour too
     */
    @Test
    public void getListFavoriteNeighbourNotEmpty () {

        Neighbour neighbour = service.getNeighbours ().get (0);
        service.addNeighbourFavorite (neighbour);
        assertFalse (service.getFavoriteNeighbour ().isEmpty ());
    }

    /**
     * Add a neighbour to favorite and Check if favoriteNeighbour contains neighbour added.
     */
    @Test
    public void addNeighbourToFavoriteWithSuccess () {

        Neighbour neighbourToAddFavorite = service.getNeighbours ().get(0);
        service.addNeighbourFavorite (neighbourToAddFavorite);
        assertTrue(service.getFavoriteNeighbour ().contains (neighbourToAddFavorite));
    }

    @Test
    public void removeNeighbourToFavoriteWithSuccess () {

        Neighbour neighbourToRemoveFavorite = service.getNeighbours ().get (3);
        service.addNeighbourFavorite (neighbourToRemoveFavorite);
        assertTrue (service.getFavoriteNeighbour ().contains (neighbourToRemoveFavorite));
        service.deleteNeighbour (neighbourToRemoveFavorite);
        assertFalse (service.getFavoriteNeighbour ().contains (neighbourToRemoveFavorite));
    }
}
