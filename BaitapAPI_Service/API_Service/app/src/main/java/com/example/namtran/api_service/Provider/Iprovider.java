package com.example.namtran.api_service.Provider;

import com.example.namtran.api_service.Class.Email;

import java.util.List;

/**
 * Created by Nam Tran on 8/10/2015.
 */
public interface Iprovider {
    List<Email> get();
    long insert(int id,String title,String decription, String date);
}
