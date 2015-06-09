package fr.tpdo.instant_noises.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.tpdo.instant_noises.Category;
import fr.tpdo.instant_noises.CategoryCtrl;
import fr.tpdo.instant_noises.Noise;
import fr.tpdo.instant_noises.R;
import fr.tpdo.instant_noises.component.ItemLayout;

/**
 * Created by Lucas on 23/03/2015.
 */
public class NoiseAdapter extends ArrayAdapter<Noise> {
    private Context context;
    private int resource;
    private List<Noise> noises;

    private CategoryCtrl ctrl;


    public NoiseAdapter(Context context, int resource, List<Noise> objects, List<Category> categories) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.noises = objects;
        this.ctrl = new CategoryCtrl(categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resource, parent, false);
        final Noise noise = getItem(position);

        ItemLayout itemLayout = (ItemLayout) view.findViewById(R.id.layout_noise);
        TextView text = (TextView) view.findViewById(R.id.label);
        TextView catText = (TextView) view.findViewById(R.id.textViewCategory);

        //on recupere la categorie liée au son en cours
        Category cat = ctrl.getCategoryWithId(noise.getIdCategory());

        text.setText(noise.getLabel());
        catText.setText(cat.getName());
        int imageId = context.getResources().getIdentifier(noise.getImage(), "drawable", getContext().getPackageName());
        if (imageId != 0) {
            Picasso.with(context).load(imageId).resize(160, 160).centerCrop().into(itemLayout);
        } else{
            System.out.println("Impossible de charger l'image : " + noise.getImage());
    }



        return view;
    }


}
