
package com.openclassrooms.entrevoisins.neighbour_list;


import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickItemAction;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(ViewMatchers.withId(R.id.list_neighbours)).check((ViewAssertion) withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, (ViewAction) new DeleteViewAction()));
        // Then : the number of element is 11
        onView(ViewMatchers.withId(R.id.list_neighbours)).check((ViewAssertion) withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When we click on an item, the details screen is launched
     */
    @Test
    public void myNeighboursList_onItemCLick_OpenDetailsScreen() {
        // When perform a click on a item
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, (ViewAction) new ClickItemAction()));
        // Then : Verify Username is displayed so it means Details Screen is displayed
        onView(ViewMatchers.withId(R.id.userName)).check(matches(ViewMatchers.isDisplayed()));
    }

    /**
     * When details screen is launched, the username textview is filled
     */
    @Test
    public void myNeighboursList_OpenDetailsScreen_UsernameIsFilled() {
        // When perform a click on item 0
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, (ViewAction) new ClickItemAction()));
        // Then : Verify Username equals "Caroline" so it means the username textview is filled
        onView(ViewMatchers.withId(R.id.userName)).check(matches(ViewMatchers.withText("Caroline")));
    }

    /**
     * Verifiy that Favs tab only contains favs users
     */
    @Test
    public void FavsTab_OnlyContainFavsUSers() {
        // When perform a click on a item 0
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, (ViewAction) new ClickItemAction()));
        // Then : perform a click on favorite fab of item 0 Details Screen
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click());
        // Then : Go Back to Main Screen
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
        // Then : perform a swipe to Favs Tab
        onView(ViewMatchers.isRoot()).perform(ViewActions.swipeLeft());
        // Then : perform a click on a item 0 of favs tab to open Details Screen
        onView(ViewMatchers.withId(R.id.list_neighbours_fav))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, (ViewAction) new ClickItemAction()));
        // Then : Verify Username equals "Caroline" so it means the she's added to favs
        onView(ViewMatchers.withId(R.id.userName)).check(matches(ViewMatchers.withText("Caroline")));

    }
}