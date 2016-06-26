package com.example.namtran.contacts.Contacts_data;

import android.provider.BaseColumns;

/**
 * Created by Nam Tran on 7/6/2015.
 */
public class Mycontacts implements BaseColumns {
    String name;
    String phone;
    String email;
    String address;

    public Mycontacts() {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "name : " + name + "phone : " + phone + "email : " + email + "address : " + address;
    }
}
