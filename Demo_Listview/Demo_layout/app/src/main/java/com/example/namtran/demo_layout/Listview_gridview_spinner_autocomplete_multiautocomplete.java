package com.example.namtran.demo_layout;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Listview_gridview_spinner_autocomplete_multiautocomplete extends Activity  {
    ListView listView;
    List<Lopstringarray> data;
    String[] data2;
    GridView gridView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    String[] arrayanh,arrayviet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gridview_spinner);
        Data();
        listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.gridView);
        spinner = (Spinner) findViewById(R.id.spinner);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        Tao_adapter_ArrayAdapter adapter = new Tao_adapter_ArrayAdapter(this,R.layout.layout_adapter,data);
        /*listview_adapter_coban adapter_coban = new listview_adapter_coban(this,R.layout.layout_adapter_textview,data2);*/
        ArrayAdapter<String> adapter_coban = new ArrayAdapter<>(this,R.layout.layout_adapter_textview,data2);
        Tao_adapter_BaseAdapter adapter1 = new Tao_adapter_BaseAdapter(this,R.layout.layout_adapter,data);

        spinner.setAdapter(adapter1);


        gridView.setAdapter(adapter);
        autoCompleteTextView.setAdapter(adapter_coban);
        multiAutoCompleteTextView.setAdapter(adapter_coban);
        multiAutoCompleteTextView.setTokenizer( new MultiAutoCompleteTextView.Tokenizer() {
            @Override
            public int findTokenStart(CharSequence text, int get) {
                int i = get;
                while (i>0 && text.charAt(i-1) != ';')
                {
                    i--;
                }
                while (i<get &&text.charAt(i) == ';')
                {
                    i++;
                }
                return i;
            }

            @Override
            public int findTokenEnd(CharSequence text, int get) {
                int i = get;
                int len = text.length();
                while (i<len)
                {
                    if (text.charAt(i) == ';')
                    {
                        return  i;
                    }
                    else
                    {
                        i++;
                    }
                }
                return len;
            }

            @Override
            public CharSequence terminateToken(CharSequence text) {
                int i = text.length();
                while (i>0 && text.charAt(i-1) == ';')
                {
                    i--;
                }
                if (i>0 && text.charAt(i-1) == ';')
                {
                    return text;
                }
                else {
                    if (text instanceof Spanned) {
                        SpannableString sp = new SpannableString(text + ";");
                        TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                Object.class, sp, 0);
                        return sp;
                    } else {
                        return text + ";";
                    }
                }
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), (CharSequence) adapterView.getItemAtPosition(i),Toast.LENGTH_LONG).show();
            }
        });
        multiAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), (CharSequence) adapterView.getItemAtPosition(i),Toast.LENGTH_LONG).show();
            }
        });
        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getApplicationContext(),""+arrayanh[i], Toast.LENGTH_LONG).show();
            }
        });
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arrayanh[i],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    void Data()
    {
        data2 = getResources().getStringArray(R.array.Tienganh);
        arrayviet = getResources().getStringArray(R.array.tiengviet);
        arrayanh = getResources().getStringArray(R.array.Tienganh);
        int[] hinh = {R.drawable.vietnam,R.drawable.japan,R.drawable.korea};
        data = new ArrayList<>();
        for (int i=0 ; i<arrayanh.length;i++)
        {
            Lopstringarray lopstringarray = new Lopstringarray(arrayviet[i],arrayanh[i],hinh[i]);
            data.add(lopstringarray);
        }
    }


}
