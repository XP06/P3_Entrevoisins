
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.CookieHandler;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {


    // This is fixed
    private static int ITEMS_COUNT = 12;
    public  int   POSITION_ITEM = 0;

    private List<Neighbour> neighbourList;
    private ListNeighbourActivity mActivity;
    private NeighbourApiService mService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule = new ActivityTestRule(ListNeighbourActivity.class);



    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mService = DI.getNewInstanceApiService ();
        neighbourList = mService.getNeighbours ();


    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * Open DetailNeighbourActivity, when click on list Neighbours
     */
    @Test
    public void myNeighboursList_onCliqueItem_shouldOpenDetailActivity () {
        //Given Start Detail Activity
        //when perform a click on item position
        onView (withId (R.id.list_neighbours))
                .perform (RecyclerViewActions.actionOnItemAtPosition (POSITION_ITEM, click()));

        //then We check if textView neighbourNameTitle in DetailNeighbourActivity is displayed.
        onView(withId(R.id.neigbourName)).check(matches (isDisplayed ()));
    }

    /**
     * Check if the name in DetailNeighbourActivity is the same of the item selected.
     */

    @Test
    public void DetailNeighbourName_onDetailNeighbourActivity_isCorrect () {

        Neighbour neighbour = neighbourList.get(POSITION_ITEM);

        //Given name Textview in DetailNeighbourActivity
        //when  this Activity is opened
        onView (withId (R.id.list_neighbours))
                .perform (RecyclerViewActions.actionOnItemAtPosition (POSITION_ITEM, click ()));

        // we check if text displayed in DetailNeighbourActivity match with neighbour name
        onView (withId (R.id.neigbourName)).check (matches (withText(neighbour.getName ())));

    }


    /**
     * Check if favorite list contains 2 items marked as favorite.
     */
    @Test
    public void favoritesList_onFavoriteFrag_showFavoriteItems_selected_on_fab_favorite () {
        //Given Favorite list in favorite fragment.
        //When add 2 items in favorite onClick on floating action button.
        onView (withId (R.id.list_neighbours))
                .perform (RecyclerViewActions.actionOnItemAtPosition (POSITION_ITEM, click ()));
        onView (withId (R.id.fab_favorite))
                .perform (click ());
        pressBack ();

        onView (withId (R.id.list_neighbours))
                .perform (RecyclerViewActions.actionOnItemAtPosition (POSITION_ITEM + 1, click ()));
        onView (withId (R.id.fab_favorite))
                .perform (click ());
        pressBack ();

        //Swipe to fragment favorite
        onView (withId (R.id.container))
                .perform (swipeLeft ());

        //Check if the number of items in Favorite list is same as the Neighbours was added.
        onView (ViewMatchers.withId (R.id.list_neighboursFavorite)).check(withItemCount (2));

    }

    @Test
    public void myNeighbourListFavorit_deleteAction_shouldRemoveItemFromFavorite () {

        //Given we remove the item in the favorite Fragment

        //add item in favorite.
        onView (withId (R.id.list_neighbours))
                .perform (RecyclerViewActions.actionOnItemAtPosition (POSITION_ITEM, click ()));
        onView (withId (R.id.fab_favorite))
                .perform (click ());
        pressBack ();
        //Swipe to fragment favorite
        onView (withId (R.id.container))
                .perform (swipeLeft ());
        //check if the list is not empty
        onView (withId (R.id.list_neighboursFavorite)).check (withItemCount (1));

        //when performe a click on a delete icon
        onView (ViewMatchers.withId (R.id.list_neighboursFavorite))
                .perform (RecyclerViewActions.actionOnItemAtPosition (0, new DeleteViewAction ()));
        //Then the number of element is 0
        onView (ViewMatchers.withId (R.id.list_neighboursFavorite)).check (withItemCount (0));

    }
}

