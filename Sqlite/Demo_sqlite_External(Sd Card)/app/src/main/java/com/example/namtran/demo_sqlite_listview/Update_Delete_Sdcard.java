package com.example.namtran.demo_sqlite_listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nam Tran on 6/10/2015.
 */
public class Update_Delete_Sdcard extends Activity implements View.OnClickListener{
    EditText edtnameVi,edtnameEn;
    Button btnupdate,btndelete;
    int _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update);
        edtnameVi = (EditText) findViewById(R.id.edtnameVi);
        edtnameEn = (EditText) findViewById(R.id.edtnameEn);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        edtnameVi.setText(bundle.getString(Country.NAMEVI));
        edtnameEn.setText(bundle.getString(Country.NAMEEN));
        _id = bundle.getInt(Country._ID);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String path = Environment.getExternalStorageDirectory() + "/Download/Mcountry";
        Iprovider iprovider = new Provider(this,path);
        if (id == R.id.btnupdate)
        {
            long kt = iprovider.update(_id, edtnameVi.getText().toString(), edtnameEn.getText().toString());
            if(kt != 0)
                this.finish();
        }
        else if (id == R.id.btndelete)
        {
          long kt = iprovider.delete(_id);
          if (kt != 0)
          {
              this.finish();
          }
        }
    }
}
