package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {


    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            Log.d("MSG", "My Neighbours");
            return NeighbourFragment.newInstance();
        }
        else if (position == 1){
            Log.d("MSG", "Fav List");
            return FavNeighbourFragment.newInstance();
        }
        else return NeighbourFragment.newInstance();
    }


    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }
}