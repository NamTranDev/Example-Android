package com.example.namtran.actionmode.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.namtran.actionmode.Interface.CallBackActivity;
import com.example.namtran.actionmode.Interface.Iprovider;
import com.example.namtran.actionmode.MainActivity;
import com.example.namtran.actionmode.R;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class Dialog_insert extends DialogFragment implements DialogInterface.OnClickListener {
    EditText edtnamevi,edtnameen;
    Iprovider iprovider_dialog;
    CallBackActivity callBackActivity_dialog;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        edtnamevi = (EditText) view.findViewById(R.id.edtnamevi);
        edtnameen = (EditText) view.findViewById(R.id.edtnameen);

        iprovider_dialog = ((MainActivity)getActivity()).iprovider;

        callBackActivity_dialog = (MainActivity)getActivity();

        AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("Insert").setPositiveButton("Insert",this)
                .setNegativeButton("Cancel",this).setView(view).create();

        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == dialogInterface.BUTTON_POSITIVE)
        {
           long kt = iprovider_dialog.insert(edtnamevi.getText().toString(),edtnameen.getText().toString());
            if (kt > 0)
            { callBackActivity_dialog.Complete(true);
                dismiss();}
            else
                callBackActivity_dialog.Complete(false);
        }
        else if (i == dialogInterface.BUTTON_NEGATIVE)
        dialogInterface.dismiss();
    }
}
