package fr.tpdo.instant_noises.dao;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.tpdo.instant_noises.Noise;

public class NoiseDAO extends  AbstracDAO<Noise> {

    public NoiseDAO(Context context) {
        super(context);
    }

    @Override
      public List<Noise> findAll(Type type, int resource) {
        Type listType = new TypeToken<ArrayList<Noise>>(){}.getType();
        return super.findAll(listType, resource);
    }

    public List<Noise> findOneType(Type type, int resource, int id){
        Type listType = new TypeToken<ArrayList<Noise>>(){}.getType();
        List<Noise> all = super.findAll(listType, resource);
        List<Noise> objects = new ArrayList<>();
        for(Noise object:all){
            if(id != 5){
                if(object.getIdCategory()==id){
                    objects.add(object);
                }
            }else{
                objects.add(object);
            }

        }
        return objects;
    }
}
