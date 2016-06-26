package com.example.namtran.actionmode.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/20/2015.
 */
public class Listdata {
    protected List<String> data;

    public Listdata() {
        this.data = new ArrayList<String>();
    }



    public List<String> getData()
    {
        return this.data;
    }
}
