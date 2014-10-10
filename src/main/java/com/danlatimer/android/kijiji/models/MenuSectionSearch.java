package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import com.danlatimer.android.kijiji.fragments.AdGridFragment;

/**
 * A menu section that represents a search that has been saved.
 */
public class MenuSectionSearch extends MenuSection {

    Search mSearch;

    public MenuSectionSearch(String sectionName, Fragment fragment, Search search) {
        super(sectionName, fragment);
        mSearch = search;
    }

    public static MenuSectionSearch newInstance(String sectionName, Search search) {

        Fragment fragment = new AdGridFragment();
        MenuSectionSearch menuSectionSearch = new MenuSectionSearch(sectionName, fragment, search);

        return menuSectionSearch;
    }

}
