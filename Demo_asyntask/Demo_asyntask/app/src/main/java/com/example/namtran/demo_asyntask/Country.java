package com.example.namtran.demo_asyntask;

/**
 * Created by Nam Tran on 7/2/2015.
 */
public class Country {
    int image;
    String nameVi;
    String nameEn;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public Country(int image, String nameVi, String nameEn) {
        this.image = image;
        this.nameVi = nameVi;
        this.nameEn = nameEn;
    }
}
