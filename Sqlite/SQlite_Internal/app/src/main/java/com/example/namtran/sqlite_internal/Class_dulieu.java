package com.example.namtran.sqlite_internal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 6/8/2015.
 */
public class Class_dulieu {
    protected List<String> list;

    public Class_dulieu() {
        this.list = new ArrayList<String>();
    }
    public List<String> getSQLITE_qry()
    {
        return this.list;
    }
}
