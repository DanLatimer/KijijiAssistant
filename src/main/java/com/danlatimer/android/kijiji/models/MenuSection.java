package com.danlatimer.android.kijiji.models;

import android.app.Fragment;

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
