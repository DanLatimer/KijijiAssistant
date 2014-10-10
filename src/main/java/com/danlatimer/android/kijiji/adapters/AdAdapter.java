package com.danlatimer.android.kijiji.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        LinearLayout adView;
        if (convertView == null) {
            // initializeView
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout newView = (LinearLayout) inflater.inflate(R.layout.view_ad_list_item, parent, false);
            adView = newView;

        } else {
            adView = (LinearLayout) convertView;
        }

        // populate view
        ImageView adImageView = (ImageView) adView.findViewById(R.id.adImage);

        Drawable catDrawable = mContext.getResources().getDrawable(R.drawable.cat01);

        adImageView.setImageDrawable(catDrawable);



        return adView;
    }
}
