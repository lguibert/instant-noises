package fr.tpdo.instant_noises;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.tpdo.instant_noises.dao.CategoryDAO;

/**
 * Created by Lucas on 25/03/2015.
 */
public class DrawerArrayAdapter extends ArrayAdapter<Category> {
    private final int resource;
    private Context context;


    public DrawerArrayAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(resource, parent, false);

        TextView tv = (TextView) view.findViewById(R.id.drawerMenuItem);
        tv.setText(this.getItem(position).getName());

        return view;
    }


}
