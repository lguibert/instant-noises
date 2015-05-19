package fr.tpdo.instant_noises;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.tpdo.instant_noises.dao.CategoryDAO;
import fr.tpdo.instant_noises.dao.NoiseDAO;


public class MainActivity extends ActionBarActivity  {

    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoiseDAO noiseDAO = new NoiseDAO(this);
        CategoryDAO categoryDAO = new CategoryDAO(this);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        DrawerArrayAdapter daa = new DrawerArrayAdapter(this, R.layout.drawer_list_item, categoryDAO.findAll(Category.class, R.raw.category));
        drawerList.setAdapter(daa);
        NoiseAdapter na = new NoiseAdapter(this, R.layout.itemnoise, noiseDAO.findAll(Noise.class, R.raw.settings), categoryDAO.findAll(Category.class, R.raw.category));
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(na);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoiseDAO noiseDAO = new NoiseDAO(parent.getContext());
                CategoryDAO categoryDAO = new CategoryDAO(parent.getContext());
                NoiseAdapter na = new NoiseAdapter(parent.getContext(), R.layout.itemnoise, noiseDAO.findOneType(Noise.class, R.raw.settings, ((Category) drawerList.getAdapter().getItem(position)).getId()), categoryDAO.findAll(Category.class, R.raw.category));
                GridView gv = (GridView) findViewById(R.id.gridView);
                gv.setAdapter(na);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
