package com.danlatimer.android.kijiji.models;

import android.app.Fragment;

public class MenuSectionSearch extends MenuSection {

    Search mSearch;

    public MenuSectionSearch(String sectionName, Fragment fragment, Search search) {
        super(sectionName, fragment);
        mSearch = search;
    }

    public static MenuSectionSearch newInstance(String sectionName, Search search) {

        Fragment fragment = new Fragment();
        MenuSectionSearch menuSectionSearch = new MenuSectionSearch(sectionName, fragment, search);

        return menuSectionSearch;
    }

}
