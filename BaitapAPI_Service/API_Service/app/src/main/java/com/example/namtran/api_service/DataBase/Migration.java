package com.example.namtran.api_service.DataBase;

import java.util.ArrayList;
import java.util.List;

public class Migration {
    protected List<String> steps;

    public Migration() {
        this.steps = new ArrayList<String>();
    }


    public List<String> getSQLQuery(){
        return this.steps;
    }
}