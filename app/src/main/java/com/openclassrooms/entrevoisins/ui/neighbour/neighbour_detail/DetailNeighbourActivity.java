package com.openclassrooms.entrevoisins.ui.neighbour.neighbour_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.openclassrooms.entrevoisins.R;

import java.io.Serializable;

public class DetailNeighbourActivity extends AppCompatActivity {

    private DetailFragment mDetailFragment;
    private Serializable mNeighbour;
    public static final String NEIGHBOUR = "NEIGHBOUR";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);

        if (getIntent().hasExtra(NEIGHBOUR))
        {
            mNeighbour = getIntent().getSerializableExtra(NEIGHBOUR);
        }

        Bundle args = new Bundle();
        args.putSerializable(NEIGHBOUR,mNeighbour);

        mDetailFragment = new DetailFragment();
        mDetailFragment.setArguments(args);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detail_activity_framelayout,mDetailFragment)
                .commit();

    }
}
