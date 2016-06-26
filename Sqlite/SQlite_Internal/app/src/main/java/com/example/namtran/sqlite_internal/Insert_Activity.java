package com.example.namtran.sqlite_internal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nam Tran on 6/9/2015.
 */
public class Insert_Activity extends Activity implements View.OnClickListener{
    EditText edtnamevi,edtnameen;
    Button btnthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_insert);
        edtnamevi = (EditText) findViewById(R.id.edtnamevi);
        edtnameen = (EditText) findViewById(R.id.edtnameen);
        btnthem = (Button) findViewById(R.id.btnthem);
        btnthem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnthem)
        {
            Iprovider iprovider = new Provider(this);
            long kt = iprovider.insert(edtnamevi.getText().toString(),edtnameen.getText().toString());
            if (kt != 0)
            this.finish();
        }
    }
}
