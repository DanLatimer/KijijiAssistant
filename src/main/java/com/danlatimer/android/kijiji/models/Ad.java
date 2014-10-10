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

    public Ad(String description, String title) {
        mDescription = description;
        mTitle = title;
    }

    public void addImage(String imageURI) {
        // TODO: implement
    }

    public void addImage(Image image) {
        mImages.add(image);
    }
}
