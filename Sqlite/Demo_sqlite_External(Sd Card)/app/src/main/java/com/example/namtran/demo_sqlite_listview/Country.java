package com.example.namtran.demo_sqlite_listview;

/**
 * Created by Nam Tran on 6/6/2015.
 */
public class Country {
    public static final String TABLE = "Mcountry";
    public static final String _ID = "_id";
    public static final String NAMEVI = "nameVi";
    public static final String NAMEEN = "nameEn";
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

        this.nameEn = nameEn;
        this._id = _id;
        this.nameVi = nameVi;
    }
}
