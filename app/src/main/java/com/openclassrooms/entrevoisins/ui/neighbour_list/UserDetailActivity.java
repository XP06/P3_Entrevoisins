package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class UserDetailActivity extends AppCompatActivity {

    ImageView mRetour, mUserPic;
    TextView tvUsername;
    FloatingActionButton fabFavorite;
    Integer idFavItem = 0;
    TextView UserName;
    TextView LocationOn;
    TextView PhoneNumber;
    TextView Www;
    TextView tDatasAboutMe;




    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().hide();

        //CHECK IN VOISIN EST DEJA EN FAVS ET DESACTIVER LE BOUTON OU NON
        fabFavorite = findViewById(R.id.floatingActionButton);
                Neighbour nouvoVoisin = new Neighbour(Integer.parseInt(getIntent().getStringExtra("id")), getIntent().getStringExtra("name"), getIntent().getStringExtra("avatar_url"), getIntent().getStringExtra("LocationOn"), getIntent().getStringExtra("PhoneNumber"), getIntent().getStringExtra("www"), getIntent().getStringExtra("tDatasAboutMe"));
        if (FavNeighbourFragment.mNeighbours.contains(nouvoVoisin)) {
            fabFavorite.setEnabled(false);
            fabFavorite.setImageDrawable(getDrawable(R.drawable.star_filled));

        } else {
            fabFavorite.setEnabled(true);
            fabFavorite.setImageDrawable(getDrawable(R.drawable.star_empty));
        }

        // RETOUR QUAND ON CLIQUE SUR LA FLECHE RETOUR //
        mRetour = findViewById(R.id.ivBackArrow);
        mRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // RECUPERE LA DATA ENVOYE PAR L'INTENT DU RECYCLER VIEW ADAPTER ACTIVITY //

        // RECUPERE ET SET LE PSEUDO //

        tvUsername = findViewById(R.id.tvUserName);
        tvUsername.setText(getIntent().getStringExtra("name"));
        //RECUPERE ET SET L'IMAGE
        mUserPic = findViewById(R.id.ivUserAvatar);
        Glide.with(mUserPic.getContext())
                .load(getIntent().getStringExtra("avatar_url"))
                .centerCrop()
                .into(mUserPic);

        //RECUPERE ET SET LES COORDONNEES
        UserName = findViewById(R.id.UserName);
        UserName.setText(getIntent().getStringExtra("name"));

        LocationOn = findViewById(R.id.LocationOn);
        LocationOn.setText(getIntent().getStringExtra("LocationOn"));

        PhoneNumber = findViewById(R.id.PhoneNumber);
        PhoneNumber.setText(getIntent().getStringExtra("PhoneNumber"));

        Www = findViewById(R.id.Www);
        Www.setText(getIntent().getStringExtra("www"));

        tDatasAboutMe = findViewById(R.id.tDatasAboutMe);
        tDatasAboutMe.setText(getIntent().getStringExtra("tDatasAboutMe"));

        //GERE LES FAVORIS //

        fabFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserDetailActivity.this, "ADDED TO FAVS CLICKED", Toast.LENGTH_SHORT).show();

                fabFavorite.setImageDrawable(getDrawable(R.drawable.star_filled));
                fabFavorite.setEnabled(false);

                // RECUP LE NOM ET LA PHOTO ET l'ID ORIGINAL ET CREER UN MODEL "Neighbour" qui sera add a la liste des favoris //

                FavNeighbourFragment.mNeighbours.add(nouvoVoisin);

                //ON ACTUALISE L'ADAPTER DE LA FAV LISTE DU FRAGMENT POUR VOIR L'ITEM APPARAITRE //

                FavNeighbourFragment.mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(FavNeighbourFragment.mNeighbours));

                Toast.makeText(UserDetailActivity.this, "Valeur de l'id : " + getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
