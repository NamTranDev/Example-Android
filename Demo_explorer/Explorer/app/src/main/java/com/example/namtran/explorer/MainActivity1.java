package com.example.namtran.explorer;

import android.app.Activity;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class MainActivity1 extends Activity implements AdapterView.OnItemClickListener{
    GridView gridView;
    TextView txtpath;
    String mpath;
    ArrayList<String> mFilename;
    ArrayList<String> mFilepath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        mpath = Environment.getExternalStorageDirectory().getPath();
        txtpath = (TextView) findViewById(R.id.txtpath);
        gridView.setOnItemClickListener(this);
        laydulieu(mpath);
    }
    public void laydulieu(String pathdulieu)
    {
        txtpath.setText(pathdulieu);
        mFilename = new ArrayList<String>();
        mFilepath = new ArrayList<String>();

        File dulieu = new File(pathdulieu);
        mFilename.add("/...");
        mFilepath.add(dulieu.getParent());

        if (dulieu.isDirectory())
        {
            File[] files = dulieu.listFiles();
            for (int i=0;i<files.length;i++)
            {
                mFilename.add(files[i].getName());
                mFilepath.add(files[i].getAbsolutePath());
            }
        }
        Custom_gridview adapter = new Custom_gridview(this,R.layout.layout_item,mFilename);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        File file = new File(mFilepath.get(i));
        if (file.isDirectory() && !file.isHidden() && file.canRead())
        {
            laydulieu(file.getAbsolutePath());
        }
        else
        {
            Toast.makeText(this,file.getName(),Toast.LENGTH_LONG).show();
        }
    }
}
