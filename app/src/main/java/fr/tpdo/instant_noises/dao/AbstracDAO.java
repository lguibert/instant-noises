package fr.tpdo.instant_noises.dao;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lucas on 25/03/2015.
 */
public class AbstracDAO<T> {
    protected Context context;

    public AbstracDAO(Context context) {
        this.context = context;

    }

    public <T> List<T> findAll(Type type, int resource){
        List<T> objects;
        try {
            InputStream inputStream = this.context.getResources().openRawResource(resource);
            String json;
            json = IOUtils.toString(inputStream);

            objects = new Gson().fromJson(json, type);

        } catch (IOException e) {
            objects = null;
        }
        return objects;
    }
}
