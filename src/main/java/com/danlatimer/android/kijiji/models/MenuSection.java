package com.danlatimer.android.kijiji.models;

import android.app.Fragment;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a section of the navigation menu. Base class that is
 * overridden with more specific functionality.
 *
 * Contains the fragment to be displayed when the section is selected.
 */
public abstract class MenuSection {

    public static final String MENU_TYPE_KEY = "MENU_TYPE";
    public static final String MENU_SECTION_NAME_KEY = "MENU_SECTION_NAME";

    private String mSectionName;
    private Fragment mFragment;

    public MenuSection(String sectionName, Fragment fragment) {
        mSectionName = sectionName;
        mFragment = fragment;
    }

    public String getSectionName() {
        return mSectionName;
    }

    @Override
    public String toString() {
        return mSectionName;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public abstract String getType();

    public Map<String, Object> getSaveState() {
        Map<String, Object> state = new HashMap<String, Object>();
        state.put(MENU_TYPE_KEY, getType());
        state.put(MENU_SECTION_NAME_KEY, mSectionName);

        return state;
    }

    public void restoreState(Bundle savedState) {
        mSectionName = savedState.getString(MENU_SECTION_NAME_KEY);
    }

    /**
     * Factory method to create MenuSections from a serialized state
     * (saved state bundle)
     *
     * @param savedState
     * @return
     */
    public static MenuSection buildMenuSection(Bundle savedState) {
        String type = savedState.getString(MENU_TYPE_KEY);

        if(type.equals(MenuSectionNewSearch.type)) {
            return MenuSectionNewSearch.newInstance(savedState);
        }

        if(type.equals(MenuSectionSearchResults.type)) {
            return MenuSectionSearchResults.newInstance(savedState);
        }

        return null;
    }


}
