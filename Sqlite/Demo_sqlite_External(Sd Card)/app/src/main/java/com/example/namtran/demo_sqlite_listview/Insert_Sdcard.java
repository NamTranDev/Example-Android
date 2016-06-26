package com.example.namtran.demo_sqlite_listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nam Tran on 6/8/2015.
 */
public class Insert_Sdcard extends Activity implements View.OnClickListener{
    EditText edtnameVi,edtnameEn;
    Button btnthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_insert);
        edtnameVi = (EditText) findViewById(R.id.edtnameVi);
        edtnameEn = (EditText) findViewById(R.id.edtnameEn);
        btnthem = (Button) findViewById(R.id.btnthem);
        btnthem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnthem)
        {
            String path = Environment.getExternalStorageDirectory() + "/Download/Mcountry";
            Iprovider iprovider = new Provider(this,path);
             long kt = iprovider.insert(edtnameVi.getText().toString(),edtnameEn.getText().toString());
            if (kt != 0)
             this.finish();
        }
    }
}
