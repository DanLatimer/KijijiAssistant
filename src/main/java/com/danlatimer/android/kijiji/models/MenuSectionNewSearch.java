package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import android.os.Bundle;
import com.danlatimer.android.kijiji.fragments.NewSearchFragment;

/**
 * A menu section that allows the user to create a new search.
 */
public class MenuSectionNewSearch extends MenuSection {

    public static final String type = "MENU_SECTION_NEW_SEARCH";

    public MenuSectionNewSearch(String sectionName, Fragment fragment) {
        super(sectionName, fragment);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Bundle getSaveStateBundle() {
        Bundle savedState = super.getSaveStateBundle();

        return savedState;
    }

    @Override
    public void restoreState(Bundle savedState) {
        super.restoreState(savedState);
    }

    /**
     * Creates a new MenuSection based on the saved state passed in
     *
     * @param savedState
     * @return
     */
    public static MenuSection newInstance(Bundle savedState) {
        MenuSectionNewSearch menuSection = MenuSectionNewSearch.newInstance();
        menuSection.restoreState(savedState);

        return menuSection;
    }

    public static MenuSectionNewSearch newInstance(String sectionName) {
        Fragment newSearchFragment = new NewSearchFragment();
        return new MenuSectionNewSearch(sectionName, newSearchFragment);
    }

    private static MenuSectionNewSearch newInstance() {
        String blankString = null;
        return MenuSectionNewSearch.newInstance(blankString);
    }

}
