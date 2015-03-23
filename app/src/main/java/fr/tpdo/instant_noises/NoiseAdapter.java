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

import java.util.List;

/**
 * Created by Lucas on 23/03/2015.
 */
public class NoiseAdapter extends ArrayAdapter<Noise> {
    private Context context;
    private int resource;
    private List<Noise> noises;
    private SoundPool soundPool;

    public NoiseAdapter(Context context, int resource, List<Noise> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.noises = objects;
        this.soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resource, parent, false);
        final Noise noise = getItem(position);

        ImageButton button = (ImageButton) view.findViewById(R.id.image);
        TextView text = (TextView) view.findViewById(R.id.label);



        text.setText(noise.getLabel());
        int imageId = context.getResources().getIdentifier(noise.getImage(), "drawable", getContext().getPackageName());
        Picasso.with(context).load(imageId).resize(128, 128).into(button);
        //button.setImageResource(imageId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundId = context.getResources().getIdentifier(noise.getSound(), "raw", getContext().getPackageName());

                int test = soundPool.load(context, soundId, 1);

                soundPool.play(test, 1,1,1,0,1);
            }
        });

        return view;
    }
}
