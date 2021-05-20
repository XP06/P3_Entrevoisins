package com.openclassrooms.entrevoisins.ui.neighbour.neighbour_detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class DetailFragment extends Fragment {

    @BindView (R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.neigbourName)
    TextView neighbourName;
    @BindView(R.id.pictureNeighbour)
    ImageView neighbourPicture;
    @BindView(R.id.tv_socialNetwork)
    TextView social;
    @BindView(R.id.fab_favorite)
    FloatingActionButton fab_favorite;


    private NeighbourApiService mApiService;
    protected Neighbour mNeighbour;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args.getSerializable(DetailNeighbourActivity.NEIGHBOUR) != null){
            mNeighbour = (Neighbour) args.getSerializable(DetailNeighbourActivity.NEIGHBOUR);
        }
        mApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        neighbourName.setText(mNeighbour.getName());
        social.setText("www.facebook.fr/" + mNeighbour.getName());

        Glide.with(this)
                .load(mNeighbour.getAvatarUrl())
                .centerCrop()
                .into(neighbourPicture);

        setFavoriteImage();

        fab_favorite.setOnClickListener(v -> setFabFavorite());

        toolbar.setNavigationOnClickListener (v -> {
            this.getActivity ().finish ();
        });

        // add toolbar and back home
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        ((AppCompatActivity)getActivity()).getSupportActionBar ().setTitle (mNeighbour.getName ());

        toolbar.setNavigationOnClickListener(v -> {
            // back button pressed
            getActivity().finish();
        });

        return view;
    }


    private void setFavoriteImage() {
        if (mApiService.isFavorite(mNeighbour)){
            fab_favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_24dp));
        }
        else{
            fab_favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_24dp));
        }
    }

    public void setFabFavorite(){
        if (mApiService.isFavorite(mNeighbour)){
            mApiService.removeFavoriteNeighbour(mNeighbour);
            Toast.makeText(this.getContext(),"Le voisin à été suprimé dans vos favoris", Toast.LENGTH_SHORT).show();
            setFavoriteImage();
        }
        else{
            mApiService.addNeighbourFavorite(mNeighbour);
            Toast.makeText(this.getContext(),"Le voisin à été ajouté dans vos favoris", Toast.LENGTH_SHORT).show();
            setFavoriteImage();
        }
    }

}
