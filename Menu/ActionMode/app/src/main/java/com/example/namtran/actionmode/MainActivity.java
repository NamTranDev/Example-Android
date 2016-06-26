package com.example.namtran.actionmode;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.namtran.actionmode.Adapter.Setadapter;
import com.example.namtran.actionmode.Dialog.Dialog_insert;
import com.example.namtran.actionmode.Interface.CallBackActivity;
import com.example.namtran.actionmode.Interface.Iprovider;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements CallBackActivity {
    ListView listView;
    public Iprovider iprovider;
    List<Country> list;
    SearchView searchView;
    Setadapter setadapter;
    SparseBooleanArray item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(listener);
        iprovider = new Provider(this);
        item = new SparseBooleanArray();
        Show();
    }

    AbsListView.MultiChoiceModeListener listener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
            String title = "Selected Item " + listView.getCheckedItemCount();
            actionMode.setTitle(title);
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main,menu);
            actionMode.setTitle("Select item : 0");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId())
            {
                case R.id.mndelete :
                        item = listView.getCheckedItemPositions();
                        for (int i = item.size() - 1; i >= 0; i--)
                        {
                            int key = item.keyAt(i);
                            Log.d("Get(key)", String.valueOf(item.get(key)));
                            if (item.get(key) == true)
                            {iprovider.delete(list.get(key).get_id());}
                        }
                        Show();
                    actionMode.finish();
                    return true;

                default:
                return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            item.clear();
            setadapter.notifyDataSetChanged();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        /*MenuItem menuItem = (MenuItem) findViewById(R.id.mnsearch);

        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                setadapter.getFilter().filter(s);
                return true;
            }
        });*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnadd) {
            Dialog_insert insert = new Dialog_insert();
            insert.show(getFragmentManager(),"Insert");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Complete(boolean Success) {
        if (Success == true)
        {
            Toast.makeText(this,"Complete",Toast.LENGTH_LONG).show();
            Show();
        }
        else
            Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
    }
    void Show()
    {
        list = iprovider.get();
        setadapter = new Setadapter(this,R.layout.layout_listview_item,list);
        listView.setAdapter(setadapter);
    }
}
