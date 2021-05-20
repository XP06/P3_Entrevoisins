package com.openclassrooms.entrevoisins.events;


import android.content.Intent;
import android.view.View;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour.neighbour_detail.DetailNeighbourActivity;

import java.io.Serializable;

/**
 * Event fired when a user Cliqk on NeighbourItem ---> start DetailNeighbourActivity
 */

public class DetailNeighbourEvent {

    public Neighbour neighbour;

    /**
     * Constructor
     * @param neighbour
     * @param v
     */

    public DetailNeighbourEvent (Neighbour neighbour, View v) {
        this.neighbour = neighbour;
        Intent intent = new Intent(v.getContext(), DetailNeighbourActivity.class);
        intent.putExtra(DetailNeighbourActivity.NEIGHBOUR, (Serializable) neighbour);
        v.getContext().startActivity(intent);
    }
}
