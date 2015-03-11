package com.danlatimer.android.kijiji.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RectangleImageView extends ImageView {
    public RectangleImageView(Context context) {
        super(context);
    }

    public RectangleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectangleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Drawable drawable = getDrawable();
        if(drawable == null) {
            return;
        }

        double originalHeight = drawable.getIntrinsicHeight();
        double originalWidth = drawable.getIntrinsicWidth();

        int imageViewHeight = getMeasuredHeight();
        int imageViewWidth = getScaledWidth(originalWidth, originalHeight, imageViewHeight);

        setMeasuredDimension(imageViewWidth, imageViewHeight);
    }

    /**
     * Gets the scaled width to preserve the aspect ratio
     *
     * @param originalWidth
     * @param originalHeight
     * @param newHeight
     * @return
     */
    private int getScaledWidth(double originalWidth, double originalHeight, double newHeight) {
        return (int) Math.floor(newHeight * (originalWidth / originalHeight));
    }
}
