package com.danlatimer.android.kijiji.models;

import android.app.Fragment;

/**
 * Represents a section of the navigation menu. Base class that is
 * overridden with more specific functionality.
 *
 * Contains the fragment to be displayed when the section is selected.
 */
public class MenuSection {

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

}
