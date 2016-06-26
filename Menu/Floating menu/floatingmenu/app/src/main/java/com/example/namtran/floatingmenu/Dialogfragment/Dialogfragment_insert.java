package com.example.namtran.floatingmenu.Dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.namtran.floatingmenu.Database.Country;
import com.example.namtran.floatingmenu.Interface.CallBackActivity;
import com.example.namtran.floatingmenu.Interface.Iprovider;
import com.example.namtran.floatingmenu.MainActivity;
import com.example.namtran.floatingmenu.Provider;
import com.example.namtran.floatingmenu.R;

/**
 * Created by Nam Tran on 6/17/2015.
 */
public class Dialogfragment_insert extends DialogFragment implements DialogInterface.OnClickListener{
    EditText edtnamevi,edtnameen;
    Iprovider iprovider;
    CallBackActivity callBackActivity;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layoutdialog_insert,null);

        edtnamevi = (EditText) view.findViewById(R.id.edtnamevi);
        edtnameen = (EditText) view.findViewById(R.id.edtnamen);

        iprovider = ((MainActivity) getActivity()).iprovider_main;

        callBackActivity = (MainActivity) getActivity();

        AlertDialog dialog = new AlertDialog.Builder(getActivity()).
                setTitle("Insert Country").setPositiveButton("Insert",this)
                .setNegativeButton("Cancel", this).setView(view).create();
        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == dialogInterface.BUTTON_POSITIVE)
        {
            if (iprovider.insert(edtnamevi.getText().toString(),edtnameen.getText().toString()) > 0){
                callBackActivity.comple(true);
            }
            else
                callBackActivity.comple(false);
            dismiss();
        }else if (i == dialogInterface.BUTTON_NEGATIVE)
        {
            dialogInterface.dismiss();
        }
    }
}
