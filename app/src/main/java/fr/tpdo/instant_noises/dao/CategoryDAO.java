package fr.tpdo.instant_noises.dao;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.tpdo.instant_noises.Category;

/**
 * Created by Lucas on 25/03/2015.
 */
public class CategoryDAO  extends AbstracDAO<Category>{

    public CategoryDAO(Context context) {
        super(context);
    }

    @Override
    public List<Category> findAll(Type type, int resource) {
        Type listType = new TypeToken<ArrayList<Category>>(){}.getType();
        return super.findAll(listType, resource);
    }
}
