package com.example.namtran.sqlite_internal;

/**
 * Created by dzumi on 16/05/2015.
 */
public class Country {

    public static final String TABLE_NAME = "Country";
    public static final String _ID = "_id";
    public static final String NAME_EN = "nameEn";
    public static final String NAME_VI = "nameVi";

    int _id;
    String nameEn;
    String nameVi;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public Country() {

        this._id = _id;
        this.nameEn = nameEn;
        this.nameVi = nameVi;
    }
}
