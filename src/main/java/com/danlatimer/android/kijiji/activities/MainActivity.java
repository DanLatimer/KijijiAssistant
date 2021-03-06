package com.danlatimer.android.kijiji.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.*;
import com.danlatimer.android.kijiji.R;
import com.danlatimer.android.kijiji.fragments.AdDescriptionFragment;
import com.danlatimer.android.kijiji.fragments.AdGridFragment;
import com.danlatimer.android.kijiji.fragments.NavigationDrawerFragment;
import com.danlatimer.android.kijiji.fragments.NewSearchFragment;
import com.danlatimer.android.kijiji.models.MenuSection;
import com.danlatimer.android.kijiji.models.MenuSectionNewSearch;
import com.danlatimer.android.kijiji.models.MenuSectionSearchResults;
import com.danlatimer.android.kijiji.models.Search;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, NewSearchFragment.NewSearchFragmentListener, AdGridFragment.AdGridInteractionListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private MenuSection mMenuSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        boolean navDrawerEmpty = (mNavigationDrawerFragment.getNumberOfSections() == 0);
        if(navDrawerEmpty) {
            String newSearchSection = getString(R.string.title_new_search);
            mNavigationDrawerFragment.addMenuSection(MenuSectionNewSearch.newInstance(newSearchSection));
        }

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        mNavigationDrawerFragment.selectItem(0);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (mNavigationDrawerFragment == null) {
            return;
        }

        mMenuSection = mNavigationDrawerFragment.getMenuSection(position);

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, mMenuSection.getFragment())
                .commit();

        mTitle = mMenuSection.getSectionName();
        restoreActionBar();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearchCreated(Search newSearch) {

        MenuSectionSearchResults menuSectionSearchResults = MenuSectionSearchResults.newInstance(newSearch.getSearch(), newSearch);
        mNavigationDrawerFragment.addMenuSection(menuSectionSearchResults);
        mNavigationDrawerFragment.selectItem(0);
    }

    @Override
    public void onAdSelected(int kijijiId)
    {
        // TODO: If there is space open in new fragment, otherwise open in new activity
        AdDescriptionFragment adDescriptionFragment = AdDescriptionFragment.newInstance();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, adDescriptionFragment)
                .addToBackStack(null)
                .commit();

        mTitle = adDescriptionFragment.getTitle();
        restoreActionBar();

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
