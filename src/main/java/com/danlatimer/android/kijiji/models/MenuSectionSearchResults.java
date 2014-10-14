package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import android.os.Bundle;
import com.danlatimer.android.kijiji.fragments.AdGridFragment;

import java.util.Map;

/**
 * A menu section that represents a search that has been saved.
 */
public class MenuSectionSearchResults extends MenuSection {

    public static final String type = "MENU_SECTION_SEARCH_RESULTS";
    private static final String MENU_SEARCH_KEY = "MENU_SEARCH_STRING";

    Search mSearch;

    public MenuSectionSearchResults(String sectionName, Fragment fragment, Search search) {
        super(sectionName, fragment);
        mSearch = search;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Map<String, Object> getSaveState() {
        Map<String, Object> savedState = super.getSaveState();
        savedState.put(MENU_SEARCH_KEY, mSearch.getSearch());

        return savedState;
    }

    @Override
    public void restoreState(Bundle savedState) {
        super.restoreState(savedState);
        String searchText = savedState.getString(MENU_SEARCH_KEY);
        mSearch = new Search(searchText);
    }

    public static MenuSectionSearchResults newInstance(Bundle savedState) {
        MenuSectionSearchResults menuSectionSearchResults = newInstance();
        menuSectionSearchResults.restoreState(savedState);

        return menuSectionSearchResults;
    }

    public static MenuSectionSearchResults newInstance(String sectionName, Search search) {
        Fragment fragment = new AdGridFragment();
        MenuSectionSearchResults menuSectionSearchResults = new MenuSectionSearchResults(sectionName, fragment, search);

        return menuSectionSearchResults;
    }

    private static MenuSectionSearchResults newInstance() {
        return newInstance(null, null);
    }

}
