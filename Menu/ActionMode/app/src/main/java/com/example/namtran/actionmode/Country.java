package com.example.namtran.actionmode;

/**
 * Created by Nam Tran on 6/19/2015.
 */
public class Country {
    public static final String TABLE_NAME = "Country";
    public static final String _ID = "_id";
    public static final String NAME_EN = "nameEn";
    public static final String NAME_VI = "nameVi";

    int _id;
    String nameVi;
    String nameEn;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

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

    public Country() {
        this.nameVi = nameVi;
        this.nameEn = nameEn;
        this._id = _id;
    }
}
