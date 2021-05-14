package com.openclassrooms.entrevoisins.ui.neighbour_list;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {
    private final static Fragment[] mFragments = {NeighbourFragment.newInstance(false), NeighbourFragment.newInstance(true)};

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
        return mFragments[position];
    }

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return mFragments.length;
    }
}