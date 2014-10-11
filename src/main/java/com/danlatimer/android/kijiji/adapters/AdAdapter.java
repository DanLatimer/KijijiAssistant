package com.danlatimer.android.kijiji.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.danlatimer.android.kijiji.R;
import com.danlatimer.android.kijiji.models.Ad;

/**
 * Array Adapter for Ad objects
 */
public class AdAdapter extends BaseAdapter {

    Context mContext;

    public AdAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return new Ad("title", "description");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View adView;
        if (convertView == null) {
            // initializeView
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View newView = inflater.inflate(R.layout.view_ad_list_item, parent, false);
            adView = newView;

        } else {
            adView = convertView;
        }

        // populate view

        int imageResourceId = catImageArray[position % catImageArray.length];
        Drawable catDrawable = mContext.getResources().getDrawable(imageResourceId);

//        adView.setBackground(catDrawable);

        ImageView imageView = (ImageView) adView.findViewById(R.id.adItemImage);
        imageView.setImageDrawable(catDrawable);

        return adView;
    }

    int catImageArray[] = {
            R.drawable.cat01,
            R.drawable.cat02,
            R.drawable.cat03,
            R.drawable.cat04,
            R.drawable.cat05,
            R.drawable.cat06,
            R.drawable.cat07,
    };


}
