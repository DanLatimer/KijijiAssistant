package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import com.danlatimer.android.kijiji.fragments.NewSearchFragment;

public class MenuSectionNewSearch extends MenuSection {

    public MenuSectionNewSearch(String sectionName, Fragment fragment) {
        super(sectionName, fragment);
    }

    public static MenuSectionNewSearch newInstance(String sectionName) {
        Fragment newSearchFragment = new NewSearchFragment();
        return new MenuSectionNewSearch(sectionName, newSearchFragment);
    }

}
