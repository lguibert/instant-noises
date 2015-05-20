package fr.tpdo.instant_noises;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lucas on 23/03/2015.
 */
public class NoiseAdapter extends ArrayAdapter<Noise> {
    private Context context;
    private int resource;
    private List<Noise> noises;
    private MediaPlayer mPlayer;
    private Map<Integer, Boolean> loaded;
    private Map<Integer, Integer> samplesId;
    private CategoryCtrl ctrl;


    public NoiseAdapter(Context context, int resource, List<Noise> objects, List<Category> categories) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.noises = objects;
        this.mPlayer = null;
        this.loaded = new HashMap<>();

        this.samplesId = new HashMap<>();
        this.ctrl = new CategoryCtrl(categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resource, parent, false);
        final Noise noise = getItem(position);

        ImageButton button = (ImageButton) view.findViewById(R.id.image);
        TextView text = (TextView) view.findViewById(R.id.label);
        TextView catText = (TextView) view.findViewById(R.id.textViewCategory);

        //on recupere la categorie liée au son en cours
        Category cat = ctrl.getCategoryWithId(noise.getIdCategory());

        text.setText(noise.getLabel());
        catText.setText(cat.getName());
        int imageId = context.getResources().getIdentifier(noise.getImage(), "drawable", getContext().getPackageName());
        Picasso.with(context).load(imageId).resize(128, 128).into(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int soundId = context.getResources().getIdentifier(noise.getSound(), "raw", getContext().getPackageName());
                playSound(soundId);
            }
        });

        return view;
    }

    private void playSound(int resId) {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this.context, resId);
        mPlayer.start();
    }
}
