package com.example.namtran.floatingmenu.Database;

/**
 * Created by Nam Tran on 6/16/2015.
 */
public class Country {
    public static final String TABLE_NAME = "Mcountry";
    public static final String _ID = "_id";
    public static final String NAME_VI = "nameVi";
    public static final String NAME_EN = "nameEn";
    int _id;
    String nameVi;
    String nameEn;

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Country() {
        this._id = _id;
        this.nameVi = nameVi;
        this.nameEn = nameEn;
    }
}
