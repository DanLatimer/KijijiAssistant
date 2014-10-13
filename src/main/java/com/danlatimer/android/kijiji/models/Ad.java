package com.danlatimer.android.kijiji.models;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Kijiji Advertisment
 */
public class Ad {

    List<Image> mImages = new ArrayList<Image>();
    String mTitle;
    String mDescription;
    int mKijijiId;

    public Ad(String description, String title, int kijijiId) {
        mDescription = description;
        mTitle = title;
        mKijijiId = kijijiId;
    }

    public void addImage(String imageURI) {
        // TODO: implement
    }

    public void addImage(Image image) {
        mImages.add(image);
    }

    public int getKijijiId() {
        return mKijijiId;
    }

}
