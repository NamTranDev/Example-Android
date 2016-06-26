package com.example.namtran.sqlite_internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nam Tran on 6/12/2015.
 */
public class Update_Delete_Activity extends Activity implements View.OnClickListener{
    EditText edtnameVi,edtnameEn;
    Button btnupdate,btndelete;
    long _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_delete);
        edtnameVi = (EditText) findViewById(R.id.edtnameVi);
        edtnameEn = (EditText) findViewById(R.id.edtnameEn);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        edtnameVi.setText(bundle.getString(Country.NAME_VI));
        edtnameEn.setText(bundle.getString(Country.NAME_EN));
        _id = bundle.getInt(Country._ID);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        long kt;
        Iprovider iprovider = new Provider(this);

        if (id == R.id.btnupdate)
        {
            kt =  iprovider.update(_id,edtnameVi.getText().toString(),edtnameEn.getText().toString());
            if (kt != 0)
                this.finish();
        }
        else if (id == R.id.btndelete)
        {
            kt = iprovider.delete(_id);
            if (kt != 0)
                this.finish();
        }
    }
}
