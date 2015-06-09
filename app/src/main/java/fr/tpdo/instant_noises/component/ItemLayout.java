package fr.tpdo.instant_noises.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by Anthony on 09/06/2015.
 */
public class ItemLayout extends LinearLayout implements Target {

    public ItemLayout(Context context) {
        super(context);
    }

    public ItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Drawable d = new BitmapDrawable(getResources(),bitmap);
        setBackground(d);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
