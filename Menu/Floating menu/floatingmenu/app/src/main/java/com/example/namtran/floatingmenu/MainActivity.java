package com.example.namtran.floatingmenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.namtran.floatingmenu.Database.Country;
import com.example.namtran.floatingmenu.Dialogfragment.Dialogfragment_insert;
import com.example.namtran.floatingmenu.Dialogfragment.Dialogfragment_update;
import com.example.namtran.floatingmenu.Interface.CallBackActivity;
import com.example.namtran.floatingmenu.Interface.Iprovider;

import java.util.List;


public class MainActivity extends ActionBarActivity implements CallBackActivity{
    ListView listView;
    public Iprovider iprovider_main;
    List<Country> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        String path = Environment.getExternalStorageDirectory() + "/Download/mcountry";
        iprovider_main = new Provider(this,path);
        registerForContextMenu(listView);
        Getdata();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_floating_listview,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
            Dialogfragment_insert dialog = new Dialogfragment_insert();
            dialog.show(getFragmentManager(), "Insert");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_floating_listview_item,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (id == R.id.mnUpdate)
        {
            Dialogfragment_update dialogupdate = new Dialogfragment_update();
            Bundle bundle = new Bundle();
            bundle.putInt(Country._ID, list.get(info.position).get_id());
            bundle.putString(Country.NAME_VI,list.get(info.position).getNameVi());
            bundle.putString(Country.NAME_EN, list.get(info.position).getNameEn());
            dialogupdate.setArguments(bundle);
            dialogupdate.show(getFragmentManager(),"Update");
            return true;
        }else if (id == R.id.mnDelete)
        {
            long kt = iprovider_main.delete(list.get(info.position).get_id());
            if (kt != 0)
            { Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
                Getdata();}
            else
                Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
    void Getdata()
    {
        list = iprovider_main.get();
        Custom_Adapter adapter = new Custom_Adapter(this,R.layout.layout_listview_item,list);
        listView.setAdapter(adapter);
    }

    @Override
    public void comple(boolean Success) {
        if (Success == true)
        {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
            Getdata();
        }
        else
            Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
    }
}
