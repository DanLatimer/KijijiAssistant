package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import com.danlatimer.android.kijiji.fragments.AdGridFragment;

/**
 * A menu section that represents a search that has been saved.
 */
public class MenuSectionSearchResults extends MenuSection {

    public static final String type = "MENU_SECTION_SEARCH";

    Search mSearch;

    public MenuSectionSearchResults(String sectionName, Fragment fragment, Search search) {
        super(sectionName, fragment);
        mSearch = search;
    }

    @Override
    public String getType() {
        return type;
    }

    public static MenuSectionSearchResults newInstance(String sectionName, Search search) {

        Fragment fragment = new AdGridFragment();
        MenuSectionSearchResults menuSectionSearchResults = new MenuSectionSearchResults(sectionName, fragment, search);

        return menuSectionSearchResults;
    }

}
