package fr.tpdo.instant_noises;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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


public class MainActivity extends ActionBarActivity  {

    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] datas = getResources().getStringArray(R.array.drawer_items);

        //drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawerList = (ListView) findViewById(R.id.left_drawer);

        //drawerList.setAdapter(new ArrayAdapter<String>(this,
        //       R.layout.drawer, datas));
        //drawerList.setOnClickListener(new DrawerItemClickListener());

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.settings);
            String json = IOUtils.toString(inputStream);
            Type type = new TypeToken<ArrayList<Noise>>(){}.getType();
            List<Noise> noises = new Gson().fromJson(json,type);

            InputStream inputStream2 = getResources().openRawResource(R.raw.category);
            String json2 = IOUtils.toString(inputStream2);
            Type type2 = new TypeToken<ArrayList<Category>>(){}.getType();
            List<Category> categories = new Gson().fromJson(json2,type2);

            NoiseAdapter na = new NoiseAdapter(this, R.layout.itemnoise,noises, categories);
            GridView gv = (GridView) findViewById(R.id.gridView);
            gv.setAdapter(na);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
