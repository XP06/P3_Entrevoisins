package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class Details extends AppCompatActivity {
    private ImageView avatar;
    private TextView personName;
    private TextView reseau;
    private NeighbourApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Neighbour neighbour1 = getIntent().getParcelableExtra("neighbour1");
        FloatingActionButton fab = this.findViewById(R.id.fab);
        setSupportActionBar(toolbar);

        // Changing the star status whether the nieghbour is in favorite or not
        fab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
        if (neighbour1 != null) {
            if (mApiService.getFavorites().contains(neighbour1)) {
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border_white_24dp));
            }
        }

        // Adding and deleting neighbour in favorite
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neighbour1 != null) {
                    if (mApiService.getFavorites().contains(neighbour1)) {
                        mApiService.deleteFavorite(neighbour1);
                        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border_white_24dp));
                    } else {
                        mApiService.addFavorite(neighbour1);
                        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
                    }
                }
            }
        });



        // Get Intent from first activity to start the second activity
        Intent detailsActivity = getIntent();


        // Get name from first activity
        String neighbourStr = "";
        if (neighbour1 != null)
            neighbourStr += neighbour1.getName();

        // Get name for socials
        String neighStr2 = "www.facebook.fr/";
        if (neighbour1 != null)
            neighStr2 += neighbour1.getName();

        // Get avatar from first activity
        avatar = findViewById(R.id.avatar);
        Glide.with(this)
                .load(neighbour1.getAvatarUrl())
                .into(avatar);

        // Display name on details screen
        personName = findViewById(R.id.userName);
        personName.setText(neighbourStr);
        toolbar.setTitle(neighbourStr);

        // Display name on socials
        reseau = findViewById(R.id.www);
        reseau.setText(neighStr2);

    }


}


