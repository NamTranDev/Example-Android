package com.example.namtran.allcountrys;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.namtran.allcountrys.Adapter.Adapter_ListCountry;
import com.example.namtran.allcountrys.Database.Country;
import com.example.namtran.allcountrys.Interface_Country.Iprovider;
import com.example.namtran.allcountrys.Interface_Country.Provider;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{
    private static final String KEY_IMAGE = "image";
    private static final String KEY_NAMEVI = "namevi";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_CAPTION = "caption";
    private static final String KEY_POPULATION = "population";
    private static final String KEY_ACREAGE = "acreage";
    ListView listView;
    List<Country> countries;
    Iprovider iprovider;
    Adapter_ListCountry adapter_listCountry;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = Environment.getExternalStorageDirectory() + "/Download/countrys";
        iprovider = new Provider(this,path);
        countries = new ArrayList<>();
        countries = iprovider.get();
        listView = (ListView) findViewById(R.id.listView);
        adapter_listCountry = new Adapter_ListCountry(this,R.layout.layout_listview_country,countries);
        listView.setAdapter(adapter_listCountry);
        listView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);

        MenuItem menuItem = menu.findItem(R.id.mnsearch);

        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter_listCountry.getFilter().filter(s);
                return true;
            }
        });
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,Countries.class);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_IMAGE,countries.get(i).getImage());
        bundle.putString(KEY_NAMEVI,countries.get(i).getNameVi());
        bundle.putString(KEY_LANGUAGE,countries.get(i).getLanguage());
        bundle.putString(KEY_CAPTION,countries.get(i).getCaption());
        bundle.putString(KEY_POPULATION,String.valueOf(countries.get(i).getPopulation()));
        bundle.putString(KEY_ACREAGE,String.valueOf(countries.get(i).getAcreage()));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
