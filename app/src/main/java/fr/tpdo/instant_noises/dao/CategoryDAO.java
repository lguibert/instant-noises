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

    public List<Integer> findAllChild(Type type, int resource, int id) {
        Type listType = new TypeToken<ArrayList<Category>>(){}.getType();
        List<Category> all = findAll(listType, resource);
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        for(Category object:all){
            if(object.getIdParent()==id){
                ids.addAll(findAllChild(type,resource,object.getId()));
            }
        }
        return ids;
    }
}
