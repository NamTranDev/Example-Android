package com.example.namtran.xml_json;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    ListView listView;
    Button btnxmlsax,btnxmldom,btnjson,btngson;
    List<Employee> employeeList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnxmlsax = (Button) findViewById(R.id.btnxmlsax);
        btnxmldom = (Button) findViewById(R.id.btnxmldom);
        btnjson = (Button) findViewById(R.id.btnjson);
        btngson = (Button) findViewById(R.id.btngson);
        listView = (ListView) findViewById(R.id.listView);
        employeeList = new ArrayList<>();
        btnxmlsax.setOnClickListener(this);
        btnxmldom.setOnClickListener(this);
        btnjson.setOnClickListener(this);
        btngson.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnxmlsax)
        {
            try {
                employeeList = XMLDemo.parseEmployeewithSAX(this,R.xml.employee);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            adapter = new Adapter(this,R.layout.layout_item,employeeList);
            listView.setAdapter(adapter);
            Toast.makeText(this,"XML SAX PARSE",Toast.LENGTH_LONG).show();
        }else if (id == R.id.btnxmldom)
        {
             //InputStream inputStream = getResources().openRawResource(R.raw.employee);
             employeeList = XMLDemo.parseEmployeewithDOM(this,R.raw.employee);
             adapter = new Adapter(this,R.layout.layout_item,employeeList);
             listView.setAdapter(adapter);
            Toast.makeText(this,"XML DOM PARSE",Toast.LENGTH_LONG).show();

        }else if (id == R.id.btnjson)
        {
            employeeList = JSONDemo.parseEmployeewithJSON(this);
            adapter = new Adapter(this,R.layout.layout_item,employeeList);
            listView.setAdapter(adapter);
            Toast.makeText(this,"JSON JSON PARSE",Toast.LENGTH_LONG).show();
        }else if (id == R.id.btngson)
        {
            employeeList = JSONDemo.parseEmployeewithGSON(this);
            adapter = new Adapter(this,R.layout.layout_item,employeeList);
            listView.setAdapter(adapter);
            Toast.makeText(this,"JSON GSON PARSE",Toast.LENGTH_LONG).show();
        }
    }
}
