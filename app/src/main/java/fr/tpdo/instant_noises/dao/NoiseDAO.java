package fr.tpdo.instant_noises.dao;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.tpdo.instant_noises.Category;
import fr.tpdo.instant_noises.Noise;
import fr.tpdo.instant_noises.R;

public class NoiseDAO extends  AbstracDAO<Noise> {

    public NoiseDAO(Context context) {
        super(context);
    }

    @Override
      public List<Noise> findAll(Type type, int resource) {
        Type listType = new TypeToken<ArrayList<Noise>>(){}.getType();
        return super.findAll(listType, resource);
    }

    public List<Noise> findOneType(Type type, int resource, int id) {
        List<Noise> all = findAll(type, resource);
        List<Noise> objects = new ArrayList<>();
        List<Integer> ids = new CategoryDAO(context).findAllChild(Category.class, R.raw.category, id);
        for (Integer identifiant : ids){
            for (Noise object : all) {
                if (object.getIdCategory()==identifiant) {
                    objects.add(object);
                }
            }
        }
        return objects;
    }
}
