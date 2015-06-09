package fr.tpdo.instant_noises;


import android.media.MediaPlayer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

import fr.tpdo.instant_noises.adapter.DrawerArrayAdapter;
import fr.tpdo.instant_noises.adapter.NoiseAdapter;
import fr.tpdo.instant_noises.dao.CategoryDAO;
import fr.tpdo.instant_noises.dao.NoiseDAO;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private GridView gridView;
    private NoiseAdapter noiseAdapter;

    private MediaPlayer mPlayer;

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

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnItemClickListener(this);


        List<Noise> noises = noiseDAO.findAll(Noise.class, R.raw.settings);
        List<Category> categories = categoryDAO.findAll(Category.class, R.raw.category);
        refresh(noises,categories);


        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoiseDAO noiseDAO = new NoiseDAO(parent.getContext());
                CategoryDAO categoryDAO = new CategoryDAO(parent.getContext());
                Category cat = (Category) drawerList.getAdapter().getItem(position);
                List<Noise> noises = noiseDAO.findOneType(Noise.class, R.raw.settings, cat.getId());
                List<Category> categories = categoryDAO.findAll(Category.class, R.raw.category);
                refresh(noises,categories);
                drawerLayout.closeDrawer(drawerList);
            }
        });
    }


    private void refresh(List<Noise> noises, List<Category> categories){
        noiseAdapter = new NoiseAdapter(this, R.layout.itemnoise, noises, categories);
        gridView.setAdapter(noiseAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Noise noise = noiseAdapter.getItem(position);

        final int soundId = getResources().getIdentifier(noise.getSound(), "raw", getPackageName());
        playSound(soundId);
    }

    private void playSound(int resId) {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, resId);
        mPlayer.start();
    }
}
