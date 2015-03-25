package fr.tpdo.instant_noises.dao;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.tpdo.instant_noises.Noise;

/**
 * Created by Lucas on 25/03/2015.
 */
public class NoiseDAO extends  AbstracDAO<Noise> {

    public NoiseDAO(Context context) {
        super(context);
    }

    @Override
      public List<Noise> findAll(Type type, int resource) {
        Type listType = new TypeToken<ArrayList<Noise>>(){}.getType();
        return super.findAll(listType, resource);
    }
}
